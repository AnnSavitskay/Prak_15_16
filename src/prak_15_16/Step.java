package prak_15_16;

public class Step implements Runnable{
    protected String which_leg;
    public Step(String which_leg)
    {
        this.which_leg = which_leg;
    }

    public void run()
    {
        while(true)
        {
            synchronized (Robot.monitor) {
                System.out.println(which_leg);
                Robot.monitor.notify();
                try {
                    Robot.monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
