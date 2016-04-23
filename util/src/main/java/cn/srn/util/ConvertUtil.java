package cn.srn.util;

/**
 * Created by SRn on 2016/4/23.
 */
public class ConvertUtil {

    public static long strToLong(String value) {
        return strToLong(value, 0);
    }

    public static long strToLong(String value, long defaultValue) {
        return strToLong(value, defaultValue, 10);
    }

    public static long strToLong(String value, long defaultValue, int radix) {
        try {
            return Long.parseLong(value, radix);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
