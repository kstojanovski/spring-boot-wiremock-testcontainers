package com.acme.sbwmtce;

import com.acme.sbwmtce.album.AlbumClientWireMockTest;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ResourceFileReader {

    public static @NotNull String readContentFromResourcesFile(String pathToFile) {
        try {
            return Files.readString(Paths.get(Objects.requireNonNull(AlbumClientWireMockTest.class.getClassLoader().getResource(pathToFile)).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static @NotNull String getWireMockJsonFile(String fileName) {
        return "wiremock/" + fileName + ".json";
    }

}
