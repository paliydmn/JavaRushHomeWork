package com.dima.tests.GUI;

import java.awt.*;
import java.awt.event.InputMethodListener;

/**
 * Created by Dima on 09.09.2016.
 */
public class Demo extends Frame
{
    Panel panel;
    Label label;
    Button button;
    TextField textField;
    TextArea textArea;
    List list;
    Checkbox checkbox;
    Scrollbar scrollbar;


    public Demo(String title) throws HeadlessException
    {
        super(title);
        setLayout(null);

        label = new Label("Test label ");
        label.setBounds(20,20,150,50);
        add(label);

        button = new Button("Button");
        button.setBounds(20,70,100 ,50);
        add(button);

        textField = new TextField("textField");
        textField.setBounds(20,150,150,50);
        textField.setColumns(5);
        Color c = new Color(1,255,5,45);
        textField.setBackground(c);
        InputMethodListener inputMethodListener;
        add(textField);


        textArea = new TextArea("Test text area");
        textArea.setBounds(20,200,150,150);
        add(textArea);
        /*

        panel = new Panel();
        panel.setBounds(50,50,300,300);

        label = new Label("Pannel is here");
        panel.add(label);


        add(panel);
*/

        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        Demo d = new Demo("Demo frame");
    }
}
