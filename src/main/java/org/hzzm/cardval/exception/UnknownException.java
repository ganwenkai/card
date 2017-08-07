package org.hzzm.cardval.exception;

/**
 * Created by jwang on 2017/4/25.
 */
public class UnknownException extends Exception {
    public UnknownException(Exception e) {
        super("发生未知异常", e);
    }
    public UnknownException(String msg){
        super();
    }
}
