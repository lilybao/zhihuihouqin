package com.lcworld.exception;

public class ZHHQException extends RuntimeException{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String errMsg ;
    private int errorCode;

   
    public ZHHQException(int errorCode,String errMsg){
        super();
        this.errorCode=errorCode;
        this.errMsg = errMsg;
    }


    public String getErrMsg() {
        return errMsg;
    }


    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }


    public int getErrorCode() {
        return errorCode;
    }


    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    
    public String toString(){
        return "errorCode:"+errorCode+"errorMsg : "+ errMsg;
    }
    
}
