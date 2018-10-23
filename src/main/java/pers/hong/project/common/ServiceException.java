package pers.hong.project.common;

/**
 * @Description: 业务异常
 * @Auther: zwh
 * @Date: 2018/10/23
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
