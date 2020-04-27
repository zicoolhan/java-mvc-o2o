package com.czh.util;

public class PathUtil {
    private static String separator = "/";

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath;
        if (os.toLowerCase().startsWith("win")) {
            basePath="D:/projectdev.image/";
        } else {
            basePath = "/Users/czh/Documents";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    public static String getShopImagePath(Long shopId) {
        String imagePath="/upload/images/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
