package cn.edu.hbut.manage.permission.service;

import cn.edu.hbut.manage.permission.dao.UserDao;
import cn.edu.hbut.manage.permission.entity.User;
import cn.edu.hbut.manage.permission.enumtype.PermissionType;
import cn.edu.hbut.manage.permission.exception.AccessDeniedException;
import cn.edu.hbut.manage.permission.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public User findUserById(Long id) throws ResourceNotFoundException, AccessDeniedException{

        User user;

        user = userDao.queryUserById(id);

        if(user.getPermissions().size() == 0){
            throw new ResourceNotFoundException("permission not found.");
        }

        for (var permission : user.getPermissions()) {
            if(permission.getPermissionType() == PermissionType.ACCESS_DENIED){
                throw new AccessDeniedException("access denied.");

            }
        }

        return user;

    }

}
