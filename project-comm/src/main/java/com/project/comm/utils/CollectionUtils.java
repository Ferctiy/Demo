package com.project.comm.utils;

import java.util.Collection;

public class CollectionUtils {

    /**
     * Entries isEmpty
     * @param entries
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> Boolean isEmpty(T... entries){
        return entries == null || entries.length == 0;
    }

    /**
     * Collection isEmpty
     * @param collection
     * @param <T>
     * @return
     */
    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

}
