package cn.edu.hbut.manage.permission.controller;

import cn.edu.hbut.manage.permission.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest extends UserController{

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetUserById() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // use reflection to test private method.
        Method method = this.getClass().getSuperclass().getDeclaredMethod("getUserById", Long.class);
        method.setAccessible(true);
        ResponseEntity<User> o = (ResponseEntity<User>)method.invoke(this, 1L);
        User user = o.getBody();
        assertEquals(user.getName(), "liujinhang");

    }

    @AfterEach
    void tearDown() {
    }
}