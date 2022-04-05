package chess.web.controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;

public final class RequestBody {

    private final Map<String, String> value;

    private RequestBody(final Map<String, String> value) {
        this.value = value;
    }

    public static RequestBody of(final String body) {
        return Arrays.stream(body.strip().split("\n"))
                .map(s -> s.split("="))
                .collect(collectingAndThen(toMap(RequestBody::extractKey, RequestBody::extractValue), RequestBody::new));
    }

    public static String extractKey(final String[] value) {
        return value[0];
    }

    public static String extractValue(final String[] value) {
        return value[1];
    }

    public String get(String key) {
        return value.get(key).strip();
    }
}

