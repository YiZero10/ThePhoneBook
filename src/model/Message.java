package model;

public class Message {

    private  int id;//编号

    private String name;//名字

    private String phoneNum;//电话号码

    private Type type;//分组，办公、个人、商务

    private String email;//邮箱

    private String qqNum;//QQ号

    private String remark;//备注

    public Message(int id, String name, String phoneNum, Type type, String email, String qqNum, String remark) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.type = type;
        this.email = email;
        this.qqNum = qqNum;
        this.remark = remark;
    }

    public Message( String name, String phoneNum, String email, String qqNum, String remark) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.qqNum = qqNum;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
