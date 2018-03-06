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

                Class carClass=carList.get(i).getClass();
                Field carName=carClass.getDeclaredField("name");
                carName.setAccessible(true);
                carName.set(carList.get(i),carProperties[0]);

                Field carYear=carClass.getDeclaredField("year");
                carYear.setAccessible(true);
                carYear.set(carList.get(i),carProperties[1]);

                Field carKilometre=carClass.getDeclaredField("kilometre");
                carKilometre.setAccessible(true);
                carKilometre.set(carList.get(i),carProperties[2]);

                Field carPrice=carClass.getDeclaredField("price");
                carPrice.setAccessible(true);
                carPrice.set(carList.get(i),carProperties[3]);

                //System.out.println(carList.get(i).getName() + ' ' +carList.get(i).getYear() + ' ' +carList.get(i).getKilometre() + ' ' +carList.get(i).getPrice());

                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
