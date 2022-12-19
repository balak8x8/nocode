package com.nocode.util;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;
import com.jcabi.aspects.Loggable;

@Component
@Loggable(prepend = true, logThis = true)
public class MapperUtilImpl implements MapperUtil {
    private DozerBeanMapper mapper = new DozerBeanMapper();

    public <T> T map(Object src, Class<T> dest) {
        return src == null ? null : this.mapper.map(src, dest);
    }
}
