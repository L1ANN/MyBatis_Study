package domain;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 22:32 2017/11/1
 * @Modified By:
 */
public class Student {
    //定义属性，和student表中的字段对应
    private int id;     //id--->s_id
    private String name;//name--->s_name

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
