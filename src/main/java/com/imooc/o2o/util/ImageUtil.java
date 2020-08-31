package com.imooc.o2o.util;

import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.imooc.o2o.dto.ImageHolder;
import javafx.animation.PauseTransition;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat(("yyyyMMddHHmmss"));
    private static final Random r = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 将 CommonsMultipartFile 转换成 File，为了方便在 generateThumbnail 时输入格式为 File
     * @param cFile
     * @return
     */
    public static File tranferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IllegalStateException e) {
            logger.error(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }
    /**
     * 处理缩略图，并返回新生成图片的相对值路径
     * @param targetAdd
     * @return
     */
    public static String generateThumbnail(ImageHolder thumbnail, String targetAdd) {
        String realFileName = getRandomFileName();// 随机名
        String extension = getFileExtension(thumbnail.getImageName()); // 扩展名
        makeDirPath(targetAdd);
        String relativeAdd = targetAdd + realFileName + extension;
        logger.debug("current relativeAdd is: " + relativeAdd);
        File dest = new File(PathUtil.getImgBasePath() + relativeAdd);
        logger.debug("current complete add is: " + PathUtil.getImgBasePath() + relativeAdd);
        logger.debug("basepath is: " + basePath);
        // 注释：原本的 ImageIO 应该读取 basePath 的内容，但是因为target 文件夹发布内容的时候，目录会被清空，因此需要定位到main下面去
        try {
            Thumbnails.of(thumbnail.getImage()).size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("C:\\Users\\luoyi\\IdeaProjects\\o2o\\src\\main\\resources\\watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAdd;
    }
    public static String generateNormalImg(ImageHolder thumbnail, String targetAdd) {
        // 获取不重复的随机名
        String realFileName = getRandomFileName();
        // 获取文件的扩展名如png,jpg等
        String extension = getFileExtension(thumbnail.getImageName());
        // 如果目标路径不存在，则自动创建
        makeDirPath(targetAdd);
        // 获取文件存储的相对路径(带文件名)
        String relativeAdd = targetAdd + realFileName + extension;
        logger.debug("current relativeAdd is :" + relativeAdd);
        // 获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAdd);
        logger.debug("current complete add is :" + PathUtil.getImgBasePath() + relativeAdd);
        // 调用Thumbnails生成带有水印的图片
        try {
            Thumbnails.of(thumbnail.getImage()).size(337, 640)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .outputQuality(0.9f).toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            throw new RuntimeException("创建缩图片失败：" + e.toString());
        }
        // 返回图片相对路径地址
        return relativeAdd;
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟 + 五位随机数
     * 时间用 SimpleDateFormat 生成
     * 随机数用 Random 生成
     * @return
     */
    public static String getRandomFileName() {
        int ranNum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + ranNum;
    }

    /**
     * 获取输入文件流的扩展名
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 创建目标路径所涉及到的目录，即 /home/work/yifan/xxx.jpg,
     * 那么 work，home，yifan 这三个文件夹都得自动创建
     * @param targetAdd
     */
    private static void makeDirPath(String targetAdd) {
        // targetAdd 只是相对路径，还需要获得绝对路径
        String realFileParentPath = PathUtil.getImgBasePath() + targetAdd;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * storePath 是文件路径还是目录的路径，
     * 如果storePath 是文件路径则删除文件，
     * 如果是目录路径则删除该目录下所有文件
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("C:\\Users\\luoyi\\Desktop\\robin.jpg")).size(200,200)
                .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                .outputQuality(0.8f).toFile("C:\\Users\\luoyi\\Desktop\\robinnew.jpg");
    }


}
