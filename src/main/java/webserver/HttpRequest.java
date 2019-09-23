package webserver;

import exception.NotFoundRequestElementException;

import java.util.Map;
import java.util.Objects;

public class HttpRequest {
    private static final String METHOD = "Method";
    private static final String BODY_PARAMETER_SEPARATOR = "?";

    private Map<String, String> header;
    private Map<String, String> parameter;

    public HttpRequest(Map<String, String> header, Map<String, String> parameter) {
        this.header = header;
        this.parameter = parameter;
    }

    public String getMethod() {
        return header.get(METHOD).split(" ")[0];
    }

    public String getPath() {
        String path = header.get(METHOD).split(" ")[1];

        if (path.contains(BODY_PARAMETER_SEPARATOR)) {
            return path.substring(0, path.lastIndexOf(BODY_PARAMETER_SEPARATOR));
        }

        return path;
    }

    public String getHeader(String key) {
        String element = header.get(key);

        if (Objects.isNull(element)) {
            throw new NotFoundRequestElementException();
        }
        return element;
    }

    public String getParameter(String key) {
        return parameter.get(key);
    }
}