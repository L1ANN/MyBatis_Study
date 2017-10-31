package domain;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 15:01 2017/10/31
 * @Modified By:
 */
public class User {
    private int id;
    private String name;
    private int age;

    public User(){}

    public User(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}