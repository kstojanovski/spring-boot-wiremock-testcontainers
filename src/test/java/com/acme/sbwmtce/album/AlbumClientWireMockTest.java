package com.acme.sbwmtce.album;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.wiremock.integrations.testcontainers.WireMockContainer;

import static com.acme.sbwmtce.ResourceFileReader.getWireMockJsonFile;
import static com.acme.sbwmtce.ResourceFileReader.readContentFromResourcesFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers
public class AlbumClientWireMockTest {

    private static final String ALBUM = "album";

    @Container
    static WireMockContainer wireMockContainer = new WireMockContainer("wiremock/wiremock:3.10.0")
            .withMappingFromJSON(
                    ALBUM,
                    readContentFromResourcesFile(getWireMockJsonFile(ALBUM))
            );

    @Autowired
    AlbumClient client;

    @Test
    void testFind() {
        Album album = client.find(1L);
        assertEquals(1L, (long)album.id());
        assertEquals(1L, (long)album.userId());
        assertEquals("quidem molestiae enim", album.title());
    }

    @SuppressWarnings("unused")
    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        Integer wireMockContainerPort = wireMockContainer.getPort();
        registry.add("album.rest.client.url", () -> wireMockContainer.getBaseUrl().replace(":".concat( String.valueOf(wireMockContainerPort)), ""));
        registry.add("album.rest.client.port", () -> wireMockContainerPort);
    }

}
