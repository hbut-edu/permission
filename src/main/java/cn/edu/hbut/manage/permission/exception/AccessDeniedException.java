package cn.edu.hbut.manage.permission.exception;

public class AccessDeniedException extends Exception {

    public AccessDeniedException(String message) {
        super(message);
    }
}
