package com.imooc.o2o.util;

public class PathUtil {
    /**
     * 1. 根据执行环境的不同，提供不同的根路径；
     * 2. 依据不同业务需求，返回不同子路径
     * @return
     */
//    private static String separator = System.getProperty("file.separator");
    private static String separator = "/";
    public static String getImgBasePath() {

        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/JavaProject/image/";
        } else {
            basePath = "/home/yifan/image/";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    public static String  getShopImagePath(long shopId) {
        String imagePath = "upload/item/shop/" +shopId + "/";
        return imagePath.replace("/", separator);
    }
}
