package skeleton.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import skeleton.Application;
import sketelon.common.Constants;

import java.nio.charset.StandardCharsets;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackageClasses = Application.class)
class ApplicationConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * Jaxb2Marshaller 类将实体类映射为xml格式的文件，需要设置扫描的路径
     * @return
     */
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("sketelon.entity");
        return jaxb2Marshaller;
    }

    /**
     * <h4>ReloadableResourceBundleMessageSource</h4>类加载国际化的翻译资源
     * 需要设置文件的基本名称，编码采用的字符集，超时时间
     * @return ReloadableResourceBundleMessageSource
     */
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource
                = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.setBasenames(Constants.ResourceURI.I18N_LOCATION);

        return messageSource;

    }

    /**
     * 返回值被用来与hibernate的validate进行整合
     * @return
     */
    @Bean(name="validator")
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        LocalValidatorFactoryBean validatorFactory = new LocalValidatorFactoryBean();
        validatorFactory.setValidationMessageSource(this.messageSource());

        return validatorFactory;
    }

    /**
     * 通过注解动态代理要校验的参数，验证是否OK
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor(){
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        processor.setValidatorFactory(this.localValidatorFactoryBean());

        return processor;
    }


}