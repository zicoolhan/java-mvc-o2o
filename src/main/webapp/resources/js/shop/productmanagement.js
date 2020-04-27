$(function(){
    var listUrl = '/o2o/shopadmin/getproductlistbyshop?pageIndex=1&pageSize=999';
    var statusUrl='/o2o/shopadmin/modifyproduct';
    getlist();
    function getlist(){
        $.getJSON(
            listUrl,
            function(data) {
                if (data.success) {
                    var productList = data.productList;
                    $('.product-wrap').html('');
                    var tempHtml ='';
                    productList.map(function(item,index){
                        var textOp = "下架";
                        var contrayStatus = 0;
                        if (item.enableStatus == 0) {
                            textOp="上架";
                            contrayStatus = 1;
                        } else {
                            contrayStatus=0;
                        }
                        tempHtml += ''
                            + '<div class="row row-product now">'
                            + '<div class="col-33 product-name">'
                            + item.productName
                            + '</div>'
                            + '<div class="col-20" >'
                            + item.priority
                            + '</div>'
                            + '<div class="col-40"><a href="#" class="edit" data-id="'
                            + item.productId
                            + '" data-status="'
                            +  item.enableStatus
                            + '">编辑</a>'
                            + '<a href="#" class="status" data-id="'
                            + item.productId
                            + '" data-status="'
                            + contrayStatus
                            + '">'
                            + textOp
                            + '</a>'
                            + '<a href="#" class="preview " data-id="'
                            + item.productId
                            + '"data-status="'
                            + item.enableStatus
                            + '">预览</a>'
                            + '</div>'
                            + '</div>';
                    });
                    $('.product-wrap').html(tempHtml);
                }
            }
        );
    }
    $('#new').click(function(){
        var tempHtml = '<div class="row row-product temp">'
            + '<div class="col-33"><input class="product-input product" type="text" placeholder="商品名"></div>'
            + '<div class="col-33"><input class="product-input priority" type="text" placeholder="优先级"></div>'
            + '<div class="col-11"><a href = "#" class="button delete">下架</a></div>'
            + '</div>';
        $('.product-wrap').append(tempHtml);
    });

    //
    $('.product-wrap').on('click', 'a',
        function (e) {
            var target = $(e.currentTarget);
            if (target.hasClass('edit')) {
                window.location.href='/o2o/shopadmin/productoperation?productId=' +
                e.currentTarget.dataset.id;
            } else if (target.hasClass('status')) {
                changeItemStatus(e.currentTarget.dataset.id,e.currentTarget.dataset.status);
            } else if (target.hasClass('preview')) {
                window.location.href='/o2o/fronted/productdetail?productId=' +
                    e.currentTarget.dataset.id;
            }
        });

    function changeItemStatus(id, enableStatus) {
        //定义project json对象并添加productId以及状态（上架/下架)
        var product = {};
        product.productId = id;
        product.enableStatus = enableStatus;
        $.confirm('确定么？', function () {
            //上下架相关商品
            $.ajax({
                url: statusUrl,
                type : 'POST',
                data : {
                    productStr:JSON.stringify(product),
                    statusChange : true
                },
                dataType : 'json',
                success : function (data) {
                    if (data.success) {
                        $.toast('操作成功');
                        getlist();
                    } else {
                        $.toast('操作失败!');
                    }
                }
            })
        })
    }
});