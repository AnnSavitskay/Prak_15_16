package prak_15_16;

public class Robot {
    public Step leg_left = new Step("LEFT");
    public Step leg_right = new Step("RIGHT");

    public void stepping()
    {
        Thread step_left = new Thread(leg_left);
        Thread step_right = new Thread(leg_right);
        step_left.start();
        step_right.start();
    }
}
