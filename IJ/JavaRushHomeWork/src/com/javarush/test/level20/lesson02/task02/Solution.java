package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File file_name = new File("D:\\data.txt"); //File.createTempFile("D:\\data.txt", null);
           // File out_file_name = new File("D:\\result.txt"); //File.createTempFile("D:\\data.txt", null);
            OutputStream outputStream = new FileOutputStream(file_name);
            InputStream inputStream = new FileInputStream(file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User dima = new User();
            User dasha = new User();
            dima.setFirstName("Dima");
            dasha.setFirstName("Dasha");
            dasha.setLastName("Paliy");

            javaRush.users.add(dima);
            javaRush.users.add(dasha);

         //   javaRush.users.add(new User());

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.users.get(1).toString());
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            for (User user : users)
            {
                String hasFirstName = user.getFirstName() != null ? "yes" : "no";
                writer.println(hasFirstName);
                if (user.getFirstName() != null )
                    writer.println(user.getFirstName());

                String hasLastName = user.getFirstName() != null ? "yes" : "no";
                writer.println(hasFirstName);
                if (user.getLastName() != null )
                    writer.println(user.getLastName());

                /* String isFirstNamePresent = user.getFirstName() != null ? "yes" : "no";
                writer.print(isFirstNamePresent);

               if (isFirstNamePresent!=null)
                    isFirstNamePresent.save(outputStream);*/

/*
                writer.println(user.getFirstName());
                writer.println(user.getLastName());
                writer.println(user.isMale());*/
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int usersSize = Integer.parseInt(reader.readLine());

            String firstName = null;
            String lastName = null;


            for (int i = 0; i < usersSize; i++ )
            {
                String isFNamePresent = reader.readLine();
                if (isFNamePresent.equals("yes"))
                    firstName = reader.readLine();
                String isLNamePresent = reader.readLine();
                if  (isLNamePresent.equals("yes"))
                    lastName = reader.readLine();

               // String userFirstName = reader.readLine();
              //  String userLastName = reader.readLine();
             //    Date userBirthDate = new Date(Date.parse(reader.readLine()));
              //   boolean userIsMale = Boolean.parseBoolean(reader.readLine());
             //    User.Country userCountry = User.Country.valueOf(reader.readLine());
            //    users.add();
                users.add(new User());
            }
            reader.close();
        }
    }
}
