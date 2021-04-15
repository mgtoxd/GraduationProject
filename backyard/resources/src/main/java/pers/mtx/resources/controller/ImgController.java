package pers.mtx.resources.controller;

import io.minio.*;
import jdk.internal.util.xml.impl.Input;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.mtx.resources.util.GetContentType;
import sun.awt.image.JPEGImageDecoder;
import sun.awt.image.PNGImageDecoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Objects;
import java.util.UUID;

@RestController
public class ImgController {
    @Autowired
    MinioClient client;
    @SneakyThrows
    @RequestMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        //获取文件的后缀名 .jpg
        String suffix = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
        //使用默认时区和语言环境获得一个日历。
        Calendar rightNow    =    Calendar.getInstance();
        Integer year = rightNow.get(Calendar.YEAR);
        Integer month = rightNow.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1
        Integer day = rightNow.get(Calendar.DAY_OF_MONTH);
        String bucket = year+"-"+month;
        boolean exists = client.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!exists){
            client.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        }
        InputStream go = file.getInputStream();

//        GetContentType.getContentType();
        String fileName = UUID.randomUUID()+suffix;
        client.putObject(PutObjectArgs.builder().bucket(bucket).stream(go,go.available(),-1).object(fileName).contentType(file.getContentType()).build());
        return fileName;

    }


    @RequestMapping("/img/{bk}/{name}")
    public void getPic(@PathVariable("bk") String bucket, @PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        System.out.println(bucket);
        System.out.println(name);
        try  {
            InputStream inputStream = client.getObject(GetObjectArgs.builder().bucket(bucket).object(name).build());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            assert inputStream != null;
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/imgDes/{bk}/{name}")
    public void getPicDes(@RequestParam("w") int width,@RequestParam("h") int height,@PathVariable("bk") String bucket, @PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        System.out.println(bucket);
        System.out.println(name);
        try  {
            InputStream inputStream = client.getObject(GetObjectArgs.builder().bucket(bucket).object(name).build());
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            inputStream = zoomBySize(width,height,inputStream);
            assert inputStream != null;
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 指定长和宽对图片进行缩放
     * @param width 长
     * @param height 宽
     * @throws IOException
     */
    public static InputStream zoomBySize(int width, int height, InputStream img) throws IOException {
        //与按比例缩放的不同只在于,不需要获取新的长和宽,其余相同.
        BufferedImage image = ImageIO.read(img);
        Image _img = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        BufferedImage image1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image1.createGraphics();
        graphics.drawImage(_img, 0, 0, null);
        graphics.dispose();
//        OutputStream out = new FileOutputStream(destFile);
//        ImageIO.write(imageC, "png", out);

//        out.close();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            File imgZoomFile = new File("D:\\bb3.png");
            ImageIO.write(image1, "PNG", imgZoomFile);
            return new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            System.out.println("go");
            return null;
        }
    }
}
