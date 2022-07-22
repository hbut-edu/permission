package cn.edu.hbut.manage.permission.service;

import cn.edu.hbut.manage.permission.entity.User;
import cn.edu.hbut.manage.permission.exception.AccessDeniedException;
import cn.edu.hbut.manage.permission.exception.ResourceNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public interface UserService {

    User findUserById(Long id) throws ResourceNotFoundException, AccessDeniedException;

}
