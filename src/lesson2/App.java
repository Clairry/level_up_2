package lesson2;

import java.io.File;
import java.util.ArrayList;

public class App {
    public static ArrayList <Object> objectList=new ArrayList <Object>();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        getObjects("lesson2.classesWithFields");
    }

    public static ArrayList<Object> getObjects (String basePackage) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String realPath = basePackage.replace('.', '/');
        File directory=new File (System.getProperty("user.dir")+"/src/"+realPath);
        File[] files=directory.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().endsWith(".java")) {
                String className = basePackage + '.' + files[i].getName().substring(0, files[i].getName().length() - 5);
                //System.out.println(className);
                Class classFromPackage=Class.forName(className);
                objectList.add(classFromPackage.newInstance());
                RandomIntProcessor.process(objectList.get(objectList.size()-1));
            }
            if (files[i].isDirectory()) {
                getObjects(basePackage+"."+files[i].getName());
            }
        }
        return objectList;
    }
}
