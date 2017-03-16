package sudopkill.config;

/**
 * Created by tanzeelrana on 3/5/2017.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import sudopkill.SocialMediaWikiApplication;

@Configuration
@PropertySource("classpath:messages.properties")
@ComponentScan(basePackageClasses = SocialMediaWikiApplication.class)
class ApplicationConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}