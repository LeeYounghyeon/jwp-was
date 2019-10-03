package utils;

public class BooleanUtils {
    private static final String HTML = "html";
    private static final String PREFIX_SLASH = "/";

    public static boolean isNotHtmlOrFile(String extension) {
        return !(HTML.equals(extension) || extension.startsWith(PREFIX_SLASH));
    }

    public static boolean isFile(String extension) {
        return !extension.startsWith(PREFIX_SLASH);
    }

    public static boolean isNothing(String extension) {
        return !(isFile(extension) && extension.startsWith(PREFIX_SLASH));
    }
}
