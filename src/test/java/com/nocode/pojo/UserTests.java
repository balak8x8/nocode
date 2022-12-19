package com.nocode.pojo;

import org.junit.jupiter.api.Test;

class UserTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testAssign() {
        User user = new User();
        user.setId(new Long(1));
        user.setUserId(String.valueOf(11));
        user.setUserAge(new Integer(111));

        System.out.println(user.toString());
        System.out.println(user.hashCode());
    }

}

