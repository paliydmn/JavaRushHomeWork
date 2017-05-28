package com.javarush.test.level20.lesson07.task05;

import java.io.*;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {

   /* public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException
    {
        Solution solution = new Solution(20);

        File file = new File("D:\\data.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        solution.writeObject(objectOutputStream);

        objectOutputStream.close();
        fileOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Solution loaded = new Solution(2);
        loaded.readObject(objectInputStream);
        objectInputStream.close();
        fileInputStream.close();

    }*/


    transient private Thread runner;
    private int speed;
    transient private int i = 1;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        System.out.println("thread " + i);
        i++;
       speed++;
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException, InterruptedException
    {
        out.writeInt(speed);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        speed = in.readInt();
       /* runner = new Thread();
        runner.start();*/
    }
}
