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
            synchronized (which_leg) {
                System.out.println(which_leg);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
