package cn.edu.hbut.manage.permission.dao;

import cn.edu.hbut.manage.permission.dao.jpa.UserRepository;
import cn.edu.hbut.manage.permission.entity.User;
import cn.edu.hbut.manage.permission.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDao {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    public User queryUserById(Long id) throws ResourceNotFoundException{

        var optional = userRepository.findById(id);

        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new ResourceNotFoundException("user is not existed.");
        }

    }

}
