package utils;

import java.util.HashMap;
import java.util.Map;

public class ExtractInformationUtils {
    public static Map<String, String> extractInformation(String body) {
        Map<String, String> userInfo = new HashMap<>();
        String[] params = body.split("&");

        for (String param : params) {
            String[] separatedParam = param.split("=");
            userInfo.put(separatedParam[0], separatedParam[1]);
        }

        return userInfo;
    }
}