package com.czh.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "shopadmin", method = {RequestMethod.GET})
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation",produces ="text/html;charset=UTF-8")
    public String shopOperation() {
        return "shop/shopoperation";
    }

    @RequestMapping(value = "/shoplist",produces ="text/html;charset=UTF-8")
    public String shopList() {
        return "shop/shoplist";
    }

    @RequestMapping(value = "/shopmanagement",produces ="text/html;charset=UTF-8")
    public String shopManagement() {
        return "shop/shopmanagement";
    }

    @RequestMapping(value = "/productcategorymanagement",produces ="text/html;charset=UTF-8")
    public String productCategoryManagement() {
        return "shop/productcategorymanagement";
    }

    @RequestMapping(value = "/productoperation",produces ="text/html;charset=UTF-8")
    public String productOperation() {
        return "shop/productoperation";
    }

    @RequestMapping(value = "/productmanagement",produces ="text/html;charset=UTF-8")
    public String productManagement() {
        return "shop/productmanagement";
    }

}
