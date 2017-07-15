package skeleton.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

/**
 * Created by Administrator on 2017/7/14.
 */
@Configuration
@ComponentScan(
        basePackages = "skeleton.site",
        useDefaultFilters = false,
        includeFilters = @ComponentScan.Filter(Endpoint.class)
)
@ImportResource("classpath:soap-service-cfg.xml")
public class SoapContextConfig {

}
