package utils;

import java.util.HashMap;
import java.util.Map;

public class ExtractInformationUtils {
    private static final String EQUAL = "=";
    private static final String SEPARATOR = "&";
    private static final String DIVISION_EXTENSION = ".";
    private static final String HTML = "html";
    private static final String TEMPLATES = "./templates";
    private static final String STATIC = "./static";
    private static final int NEXT_INT = 1;

    public static Map<String, String> extractInformation(String body) {
        Map<String, String> userInfo = new HashMap<>();
        String[] params = body.split(SEPARATOR);

        addUserInfo(userInfo, params);

        return userInfo;
    }

    public static String extractExtension(String url) {
        return url.substring(url.lastIndexOf(DIVISION_EXTENSION) + NEXT_INT);
    }

    public static String getClassPath(String url, String extension) {
        if (HTML.equals(extension)) {
            return TEMPLATES + url;
        }

        return STATIC + url;
    }

    private static void addUserInfo(Map<String, String> userInfo, String[] params) {
        for (String param : params) {
            String[] separatedParam = param.split(EQUAL);
            userInfo.put(separatedParam[0], separatedParam[1]);
        }
    }
}
