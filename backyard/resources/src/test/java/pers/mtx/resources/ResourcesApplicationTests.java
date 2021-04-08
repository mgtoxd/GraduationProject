package pers.mtx.resources;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ResourcesApplication.class)
class ResourcesApplicationTests {

    @Autowired
    MinioClient client;

    @Test
    void contextLoads() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        //使用默认时区和语言环境获得一个日历。
        Calendar rightNow    =    Calendar.getInstance();
        /*用Calendar的get(int field)方法返回给定日历字段的值。
        HOUR 用于 12 小时制时钟 (0 - 11)，HOUR_OF_DAY 用于 24 小时制时钟。*/
        Integer year = rightNow.get(Calendar.YEAR);
        Integer month = rightNow.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1
        Integer day = rightNow.get(Calendar.DAY_OF_MONTH);
        String bucket = year+"-"+month;
        boolean exists = client.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!exists){
            client.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            client.uploadObject(
                    UploadObjectArgs.builder().bucket(bucket).filename("/"+day+"wada.txt").object("wdadaw").build()
            )
        }

    }

}
