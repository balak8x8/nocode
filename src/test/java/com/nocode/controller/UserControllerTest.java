package com.nocode.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    void testGetUser() throws Exception {
        System.out.println(userController.getUsers());
        userController.deleteUser(new Long(4));
        System.out.println(userController.getUsers());
    }
}
