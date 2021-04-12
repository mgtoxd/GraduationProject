package pers.mtx.resources.controller;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class ImgController {
    @Autowired
    MinioClient client;
    @GetMapping("/img/{bk}/{name}")
    public void getPic(@PathVariable("bk") String bucket, @PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        try (InputStream inputStream = client.getObject(GetObjectArgs.builder().bucket(bucket).object(name).build());
             OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());) {
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
