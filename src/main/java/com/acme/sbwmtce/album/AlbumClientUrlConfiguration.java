package com.acme.sbwmtce.album;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "album.rest.client")
public class AlbumClientUrlConfiguration {

    private String url;

    private String port;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUrlPort() {
        return url.concat(":").concat(port);
    }

}
