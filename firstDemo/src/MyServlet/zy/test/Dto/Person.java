package MyServlet.zy.test.Dto;

/**
 * Created by zy on 2018-3-21.
 */
public class Person {
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age;

    public Person(String name,int age) {
        this.age = age;
        this.name = name;
    }
}
