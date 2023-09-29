package com.rodolpho.SEASolution.util;

public class apiResponse {

    private String message;
    private Boolean sucess;

    public apiResponse() {

    }

    public apiResponse(String message, Boolean sucess) {
        this.message = message;
        this.sucess = sucess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSucess() {
        return sucess;
    }

    public void setSucess(Boolean sucess) {
        this.sucess = sucess;
    }
}
