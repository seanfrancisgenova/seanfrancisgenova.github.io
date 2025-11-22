package TA10;

import java.io.*;

public class IntegerStreamDemo {
    public static void main(String[] args) {
        String filename = "number.dat";

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            Integer num = 123;
            System.out.println("Writing Integer: " + num);

            oos.writeObject(num);
            oos.close();

            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Integer readNum = (Integer) ois.readObject();
            System.out.println("Integer read from file: " + readNum);

            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
