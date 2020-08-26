/**
 * 
 */
package com.ax.bug;

/**
 * @description:异常类
 * @author AoXiang
 * @date 2017年3月21日
 * @version 1.0
 */
public class RuleException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    public RuleException() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public RuleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public RuleException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public RuleException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public RuleException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }
}