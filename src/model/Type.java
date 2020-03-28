package model;

public enum Type {
    WORK(0,"办公"),

    PERSONAGE(1,"个人"),

    BUSINESS(2,"商务");

    private int code;
    private String message;

    Type(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
