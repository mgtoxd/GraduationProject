//package pers.mtx.resources.config;
//
//import lombok.Value;
//import org.springframework.boot.web.servlet.MultipartConfigFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.MultipartConfigElement;
//
//@Configuration
//public class FileUploadConfig {
//	/**
//	 * 文件上传配置
//	 *
//	 * @return MultipartConfigElement
//	 */
//	@Bean
//	public MultipartConfigElement multipartConfigElement(
//			@Value("${multipart.maxFileSize}") String maxFileSize,
//			@Value("${multipart.maxRequestSize}") String maxRequestSize)
//		{
//		MultipartConfigFactory factory = new MultipartConfigFactory();
//		// 单个文件最大
//		factory.setMaxFileSize(maxFileSize);
//		// 设置总上传数据总大小
//		factory.setMaxRequestSize(maxRequestSize);
//		return factory.createMultipartConfig();
//	}
//
//}
//————————————————
//版权声明：本文为CSDN博主「shareve」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/u013190497/article/details/78731270