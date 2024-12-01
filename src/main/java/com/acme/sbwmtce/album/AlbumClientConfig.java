package com.acme.sbwmtce.album;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AlbumClientConfig {

    private final AlbumClientUrlConfiguration albumClientUrlConfiguration;

    public AlbumClientConfig(AlbumClientUrlConfiguration albumClientUrlConfiguration) {
        this.albumClientUrlConfiguration = albumClientUrlConfiguration;
    }

    @Bean
    AlbumClient albumClient() {
        RestClient restClient = RestClient.create(albumClientUrlConfiguration.getUrlPort());
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        return factory.createClient(AlbumClient.class);
    }

}
