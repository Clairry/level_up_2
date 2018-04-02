package lesson2dop;

import lesson2.classesWithFields.innerClassWithPackage.oneMorePackage.User;

public class UserSerializator implements Serializer<User> {

    public UserSerializator() {};

    @Override
    public String serialize(User object) {
        return "Имя: "+object.getName();
    }
}
