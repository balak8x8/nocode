package com.nocode.util;

public interface MergeUtil {
    <T> T mergeObject(T source, Object toBeMerged)
            throws Exception;

    <T> T mergeString(T existingSource, String input)
            throws Exception;
}
