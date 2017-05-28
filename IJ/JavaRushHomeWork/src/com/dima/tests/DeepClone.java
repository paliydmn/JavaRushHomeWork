package com.dima.tests;

import java.io.*;

/**
 * Created by Dima on 19.07.2016.
 */
public class DeepClone
{

        public static Object deep(Object object) throws IOException, ClassNotFoundException
        {


        ByteArrayOutputStream writeBuffer = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(writeBuffer);
        outputStream.writeObject(object);
        outputStream.close();

        byte[] buffer = writeBuffer.toByteArray();
        ByteArrayInputStream readBuffer = new ByteArrayInputStream(buffer);
        ObjectInputStream inputStream = new ObjectInputStream(readBuffer);
        CollectionTest copy  = (CollectionTest) inputStream.readObject();

            return copy;

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        CollectionTest collectionTest = new CollectionTest();

        System.out.println(collectionTest.toString());
        System.out.println(deep(collectionTest));

    }


}
