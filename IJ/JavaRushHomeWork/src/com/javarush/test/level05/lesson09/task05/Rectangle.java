package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    private int top = 0, left = 0, width = 0, height = 0;

    public Rectangle(int left, int top, int width, int height)
    {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int left, int top)
    {
        this.left = left;
        this.top = top;
    }
    public Rectangle(int left, int top, int width)
    {
        this.left = left;
        this.top = top;
        this.width = this.height = width;
    }

    public Rectangle(Rectangle RecCopy, int left, int top, int width, int height )
    {
        this.left = RecCopy.left;
        this.top = RecCopy.top;
        this.width = RecCopy.width;
        this.height = RecCopy.height;

    }

    public static void main(String[] args)
    {
        Rectangle test = new Rectangle( 1,2,3,4);
        Rectangle test2 = new Rectangle(test, 2,3, 4,5);



        System.out.println(test2.height);
        System.out.println(test.height);
    }

    //напишите тут ваш код

}
