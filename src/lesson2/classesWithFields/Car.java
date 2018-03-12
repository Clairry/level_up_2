package lesson2.classesWithFields;

import lesson2.RandomInt;

public class Car {
    public Car() {};

    public Integer getYear() {
        return year;
    }

    public String name="Mazda 3";

    @RandomInt(min=2008, max=2018)
    public Integer year;

    @RandomInt(min=1000, max=100000)
    public Integer kilometre;

    @RandomInt(min=100000, max=1000000)
    public  Integer price;
}
