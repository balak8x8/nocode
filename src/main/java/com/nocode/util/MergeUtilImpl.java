package com.nocode.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.stereotype.Component;
import com.jcabi.aspects.Loggable;

@Component
@Loggable(prepend = true, logThis = true)
public class MergeUtilImpl implements MergeUtil {

    private ObjectMapper objectMapper = new ObjectMapper();
    private JsonUtil jsonUtil;

    public MergeUtilImpl(JsonUtil jsonUtil) {
        this.jsonUtil = jsonUtil;
    }

    public <T> T mergeString(T existingSource, String input) throws Exception {
        ObjectReader objectReader = objectMapper.readerForUpdating(existingSource);
        T updatedSource = objectReader.readValue(input);
        return updatedSource;
    }

    @Override
    public <T> T mergeObject(T source, Object toBeMerged) throws Exception {
        return mergeString(source, jsonUtil.toJSON(toBeMerged));
    }
}
