package entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: guohezuzi
 * \* Date: 2018-04-09
 * \* Time: 下午5:28
 * \* Description:用户类
 * \
 */
@Document
public class User {
    private String name;
    private String sex;
    private int age;

    public User(){
    }

    public User(String name,String sex,int age){
        this.name=name;
        this.sex=sex;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
