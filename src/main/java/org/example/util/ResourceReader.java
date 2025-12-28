package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class ResourceReader {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private ResourceReader() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String readPuzzleInput(String resourcePath){
        return readAsString(resourcePath);
    }

    public static String readAsString(String filename) {
        try (InputStream inputStream = getResourceAsStream(filename)) {
            return new String(inputStream.readAllBytes(), DEFAULT_CHARSET);
        } catch (IOException e) {
            throw new IllegalStateException("Konnte Ressource nicht lesen + " + filename, e);
        }
    }

    private static InputStream getResourceAsStream(String filename) {
        String normalized = normalize(filename);
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(normalized);

        if (inputStream == null) {
            throw new IllegalStateException("Ressource nicht gefunden");
        }
        return inputStream;
    }

    private static String normalize(String filename) {
        return filename.startsWith("/") ? filename.substring(1) : filename;
    }
}
