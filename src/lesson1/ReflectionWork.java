package lesson1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ReflectionWork {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Car> carList = new ArrayList<Car>();
        String carsLine = null;
        Integer i=0;

        try (BufferedReader carsReader = new BufferedReader(new FileReader("Cars.txt"))) {
            while ((carsLine = carsReader.readLine()) != null) {
                String[] carProperties = carsLine.split(",");
                carList.add(new Car());

                setField("name", carList.get(i), carProperties[0]);
                setField("year", carList.get(i), carProperties[1]);
                setField("kilometre", carList.get(i), carProperties[2]);
                setField("price", carList.get(i), carProperties[3]);
//                System.out.println(carList.get(i).getName() + ' ' +carList.get(i).getYear() + ' ' +carList.get(i).getKilometre() + ' ' +carList.get(i).getPrice());

                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setField(String field, Car carObj, String value) throws NoSuchFieldException, IllegalAccessException {
        Class carClass=carObj.getClass();
        Field carName=carClass.getDeclaredField(field);
        carName.setAccessible(true);
        carName.set(carObj,value);
    }
}
