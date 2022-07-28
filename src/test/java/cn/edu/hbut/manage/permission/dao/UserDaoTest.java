package cn.edu.hbut.manage.permission.dao;

import cn.edu.hbut.manage.permission.entity.User;
import cn.edu.hbut.manage.permission.exception.ResourceNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void queryUserById() throws ResourceNotFoundException {

        User user = userDao.queryUserById(1L);
        assertEquals(user.getName(), "liujinhang");

        user = userDao.queryUserById(2L);
        assertEquals(user.getName(), "ryukinkou");
    }
}