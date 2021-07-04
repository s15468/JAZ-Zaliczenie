package pl.pjatk.jazs15468nbp.NBP.Rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig
{
    @Bean
    public RestTemplate RestTemplate()
    {
        return new RestTemplate();
    }
}
