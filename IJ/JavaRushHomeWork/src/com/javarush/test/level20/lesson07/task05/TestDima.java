package com.javarush.test.level20.lesson07.task05;

import java.text.SimpleDateFormat;
import java.util.concurrent.*;
import java.io.*;
import java.util.*;
/**
 * Created by Dima on 17.05.2016.
 */
public class TestDima implements Serializable
{


        private Date date = new Date();
        private String username;
        private transient String password;
        public TestDima(String name, String pwd) {
            username = name;
            password = pwd;
        }
        public String toString() {
            return "logon info: \n   username: " + username +
                    "\n   date: " + date + "\n   password: " + password;
        }

        public static void main(String[] args) throws Exception {
            TestDima a = new TestDima("Hulk", "myLittlePony");
       //     System.out.println(("logon a = " + a));
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("D:\\data.txt"));
            o.writeObject(a);
            o.close();
            TimeUnit.SECONDS.sleep(1); // Delay
            // Now get them back:
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\data.txt"));
            String format = "dd MM yyy, EEEE";
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            System.out.println(("Recovering object at " + dateFormat.format(new Date())));
            a = (TestDima)in.readObject();
            System.out.println("logon a = " + a);
        }
    }

