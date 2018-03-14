package lesson2.classesWithFields.innerClassWithPackage.oneMorePackage;

import lesson2.RandomInt;

public class User {
    public User() {};

    public String name="Ivan";

    @RandomInt(min=10,max=100)
    public Integer age;

    @RandomInt(min=40,max=100)
    public Integer weight;

    @RandomInt(min=140,max=200)
    public Integer height;

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
