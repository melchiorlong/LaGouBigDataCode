package com.homework.Stage1.Section4.Topic4;



import java.io.Serializable;

/**
 * @author tianlong
 * 使用基于 tcp 协议的编程模型实现将 UserMessage 类型对象由客户端发送给服务器；
 * 服务器接收到对象后判断用户对象信息是否为 "admin" 和 "123456"，
 * 若是，则将 UserMessage 对象中的类型改为"success"，
 * 若否，则将类型改为"fail"并回发给客户端，客户端接收到服务器发来的对象后判断并给出登录成功或者失败的提示。
 * 其中 UserMessage 类的特征有：类型(字符串类型) 和用户对象(User 类型)。
 * 其中 User 类的特征有：用户名、密码(字符串类型)。
 * 如：
 * UserMessage tum = new UserMessage("check", new User("admin", "123456"));
 */

public class UserMessage implements Serializable {

    private static final long serialVersionUID = -6052751148579961901L;
    private String type;
    private User user;

    public UserMessage() {
    }

    public UserMessage(String type, User user) {
        this.type = type;
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "type='" + getType() + '\'' +
                ", user=" + getUser() +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
