package com.dima.tests.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Dima on 12.09.2016.
 */
public class SpringGUI
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createGUI();
            }
        });
    }

    private static void createGUI()
    {
        JList<String> list = new JList<>();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane listScrollPane = new JScrollPane(list);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(listScrollPane, BorderLayout.CENTER);

        ActionListener updateButtonListener = new UpdateListAction(list);
        updateButtonListener.actionPerformed(
                new ActionEvent(list, ActionEvent.ACTION_PERFORMED, null)
        );

        JButton updateListButton = new JButton("Update list");
        JButton updateLookAndFeelButton = new JButton("Update Look&Feel");

        JPanel btnPannel = new JPanel();
        btnPannel.setLayout(new BoxLayout(btnPannel, BoxLayout.LINE_AXIS));
        btnPannel.add(updateListButton);
        btnPannel.add(Box.createHorizontalStrut(5));
        btnPannel.add(updateLookAndFeelButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnPannel);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new BorderLayout());
        panel.add(topPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Look&Feel Switcher");
        frame.setMinimumSize(new Dimension(300, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        updateListButton.addActionListener(updateButtonListener);
        updateLookAndFeelButton.addActionListener(
                new UpdateLookAndFeelAction(frame, list)
        );

    }
    static class UpdateLookAndFeelAction implements ActionListener
    {
        private JList<String> list;
        private JFrame rootFrame;

        public UpdateLookAndFeelAction(JFrame frame, JList<String> list)
        {
            this.rootFrame = frame;
            this.list = list;
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String lookAndFeelName = list.getSelectedValue();
            UIManager.LookAndFeelInfo[] infoArray =
                    UIManager.getInstalledLookAndFeels();

            for (UIManager.LookAndFeelInfo info : infoArray)
            {
                if (info.getName().equals(lookAndFeelName))
                {
                    String message = "Look&feel was changed to " + lookAndFeelName;
                    try
                    {
                        UIManager.setLookAndFeel(info.getClassName());
                        SwingUtilities.updateComponentTreeUI(rootFrame);
                    }
                    catch (ClassNotFoundException e1)
                    {
                        message = "Error: " + info.getClassName() + " not found";
                    }
                    catch (InstantiationException e1)
                    {
                        message = "Error: instantiation exception";
                    }
                    catch (IllegalAccessException e1)
                    {
                        message = "Error: illegal access";
                    }
                    catch (UnsupportedLookAndFeelException e1)
                    {
                        message = "Error: unsupported look and feel";
                    }
                    JOptionPane.showMessageDialog(null, message);
                    break;
                }
            }
        }
    }

    static class UpdateListAction implements ActionListener
    {
        private JList<String> list;

        public UpdateListAction(JList<String> list)
        {
            this.list = list;
        }

        @Override
        public void actionPerformed(ActionEvent event)
        {
            ArrayList<String> lookAndFeelList = new ArrayList<>();
            UIManager.LookAndFeelInfo[] infoArray =
                    UIManager.getInstalledLookAndFeels();
            int lookAndFeelIndex = 0;
            int currentLookAndFeelIndex = 0;
            String currentLookAndFeelClassName =
                    UIManager.getLookAndFeel().getClass().getName();

            for (UIManager.LookAndFeelInfo info : infoArray)
            {
                if (info.getClassName().equals(currentLookAndFeelClassName))
                {
                    currentLookAndFeelIndex = lookAndFeelIndex;
                }
                lookAndFeelList.add(info.getName());
                lookAndFeelIndex++;
            }

            String[] listDataArray = new String[lookAndFeelList.size()];
            final String[] newListData =
                    lookAndFeelList.toArray(listDataArray);
            final int newSelectedIndex = currentLookAndFeelIndex;

            SwingUtilities.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    list.setListData(newListData);
                    list.setSelectedIndex(newSelectedIndex);
                }
            });
        }
    }
}
