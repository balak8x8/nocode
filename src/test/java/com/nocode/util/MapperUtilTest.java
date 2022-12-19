package com.nocode.util;

import com.nocode.entity.UserEntity;
import com.nocode.pojo.User;
import org.junit.jupiter.api.Test;

public class MapperUtilTest {

    @Test
    public void testPojoToEntity() {
        User user = new User();
        user.setId(new Long(1));
        user.setUserId(String.valueOf(11));
        user.setUserAge(new Integer(111));

        MapperUtil mapperUtil = new MapperUtilImpl();
        UserEntity userEntity = mapperUtil.map(user, UserEntity.class);

        System.out.println(userEntity.toString());
    }

    @Test
    public void testEntityToPojo() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(new Long(2));
        userEntity.setUserId(String.valueOf(22));
        userEntity.setUserAge(new Integer(222));


        MapperUtil mapperUtil = new MapperUtilImpl();
        User user = mapperUtil.map(userEntity, User.class);

        System.out.println(user.toString());
    }
}
