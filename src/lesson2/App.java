package lesson2;

import lesson2.classesWithFields.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws URISyntaxException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        getObjects("lesson2.classesWithFields");
    }

    public static ArrayList<Object> getObjects (String basePackage) throws ClassNotFoundException, IllegalAccessException, InstantiationException, URISyntaxException {
        ArrayList <Object> objectList=new ArrayList <Object>();
        File directory = null;
        String realPath = basePackage.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(realPath);
        directory = new File(resource.toURI());
        String[] files = directory.list();

        for (int i = 0; i < files.length; i++) {
            if (files[i].endsWith(".class")) {
                String className = basePackage + '.' + files[i].substring(0, files[i].length() - 6);
//                System.out.println(className);
                Class classFromPackage=Class.forName(className);
                objectList.add(classFromPackage.newInstance());
                RandomIntProcessor.process(objectList.get(i));
//                if (className.equals("lesson2.classesWithFields.House")) {
//                    House j=(House) objectList.get(i);
//                    System.out.println(j.getYearOfConstruction());
//                }
            }
        }
        return objectList;
    }
}
