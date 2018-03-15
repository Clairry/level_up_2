package lesson2.classesWithFields;

import lesson2.RandomInt;

public class House {
    public House () {};

    @RandomInt(min=2000, max=2018)
    public Integer yearOfConstruction;

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    @RandomInt(min=200, max=500)
    public Integer numberOfFlats;

}
