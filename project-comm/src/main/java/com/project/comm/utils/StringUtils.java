package com.project.comm.utils;

import java.util.Arrays;
import java.util.List;

/**
 * String Utils
 */
public class StringUtils {

    /**
     * String isEmpty
     *
     * @param value
     * @return
     */
    public static Boolean isEmpty(String value) {
        return value == null || value.isEmpty() || value.trim().isEmpty();
    }

    /**
     * Concatenate a list of strings using splitters
     *
     * @param collection list of strings
     * @param splitter   splitter
     * @return
     */
    public static String concat(List<String> collection, String splitter) {
        if (!CollectionUtils.isEmpty(collection)) {
            Boolean isNull = isEmpty(splitter);
            StringBuilder sb = new StringBuilder();
            collection.forEach(a -> {
                if (!isEmpty(a)) {
                    sb.append(sb.length() == 0 || isNull ? a : splitter.concat(a));
                }
            });
            return String.valueOf(sb);
        }
        return null;
    }

    public static boolean equalsIgnoreCase(String src, String... strings) {
        if (!isEmpty(src) && !CollectionUtils.isEmpty(strings)) {
            return Arrays.stream(strings).anyMatch(src::equalsIgnoreCase);
        }
        return false;
    }

}
