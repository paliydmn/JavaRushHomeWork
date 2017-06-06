package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Dima on 17.08.2016.
 */

 class LoggingStateThread extends Thread
{
    Thread target;
    State state;
    public LoggingStateThread(Thread target)
    {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run()
    {
      //  System.out.println(target.getState());
        State currentState = target.getState();

       System.out.println(currentState);
        while (currentState != State.TERMINATED)
        {
            currentState = target.getState();
            if (currentState != state)
            {
                state = currentState;
                System.out.println(currentState);
            }
        }

    }
}
