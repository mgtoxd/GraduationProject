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
                .endpoint("http://localhost:9000/")
                .credentials("mataoxun", "mtx990812")
                .build();
    }

}
