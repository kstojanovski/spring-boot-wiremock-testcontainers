package com.acme.sbwmtce.album;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class AlbumClientTest {

    @Autowired
    AlbumClient client;

    @Test
    void testFindAll() {
        List<Album> albums = client.findAll();
        assertEquals(100,albums.size());
    }

    @Test
    void testFind() {
        Album album = client.find(1L);
        assertEquals(1L, (long)album.id());
        assertEquals(1L, (long)album.userId());
        assertEquals("quidem molestiae enim", album.title());
    }
}