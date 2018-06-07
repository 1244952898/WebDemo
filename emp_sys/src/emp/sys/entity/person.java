package emp.sys.entity;

import emp.sys.zhujie.Column;
import emp.sys.zhujie.ID;
import emp.sys.zhujie.tableName;

/**
 * Created by zy on 2018-5-23.
 */
@tableName("a_person")
public class person {
    @ID
    @Column(ColnumName = "a_id")
    private long id;
    @Column(ColnumName = "a_name")
    private String name;
    @Column(ColnumName = "a_age")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return "person{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
