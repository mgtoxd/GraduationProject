package pers.mtx.order_con.config;
 import com.github.dozermapper.core.DozerBeanMapperBuilder;
 import com.github.dozermapper.core.Mapper;
  import com.github.dozermapper.core.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
   public class DozerBeanMapperConfigure {
       @Bean
       public Mapper mapper() {             return  DozerBeanMapperBuilder.buildDefault();         }
   }