package cn.edu.hbut.manage.permission.controller;

import cn.edu.hbut.manage.permission.entity.Error;
import cn.edu.hbut.manage.permission.entity.User;
import cn.edu.hbut.manage.permission.exception.AccessDeniedException;
import cn.edu.hbut.manage.permission.exception.ResourceNotFoundException;
import cn.edu.hbut.manage.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    private ResponseEntity getUserById(@PathVariable Long id) {

        try {

            var user = userService.findUserById(id);

            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.NOT_FOUND);
        } catch (AccessDeniedException e) {
            return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        }

    }

}
