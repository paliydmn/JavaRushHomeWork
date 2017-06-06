package com.javarush.test.level23.lesson08.task02;

/* Повторяем threads
Сделать так, чтобы в методе someActions вызывались только методы класса Solution.
Ожидаемый вывод в методе main:
Amigo: Mmmmm, beef
Amigo: knock knock
Amigo: Zzzzzzz...1 sec
*/
public class Solution {
    public final String name;
    public final String food;
    public final String sound;

    public Solution(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) throws InterruptedException
    {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " sec");
      //  Thread.sleep(500);
    }

  /*  class SolutionThread extends Thread
    {
       // Thread thread = new Thread();
        public void run() {
            try {
                someActions();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        private void someActions() throws InterruptedException {
            eat();
            play();
            sleep(1000);
        }
    }*/
    public void live() throws InterruptedException {

      /*  SolutionThread st = new SolutionThread();
        st.start();
        st.join();*/
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                    System.out.println("----------------------------------------------");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                Solution.this.sleep(1000);
            }
        };
        thread.start();
        thread.join();

    }

    public static void main(String[] args) throws InterruptedException {
        Solution test = new Solution("Amigo" , "beef", "knock");

        for (int i = 0; i < 5000; i++)
        {
            System.out.println(i);
            test.live();
        }
    }
}
