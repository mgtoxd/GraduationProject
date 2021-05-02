package pers.mtx.resources;

import io.minio.MinioClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourcesApplication.class, args);
    }
    @Bean
    public MinioClient minio() {
        return MinioClient.builder()
                .endpoint("http://172.17.0.5:9000/")
//                .endpoint("http://localhost:9000/")
                .credentials("mataoxun", "mtx990812")
                .build();
    }

}
