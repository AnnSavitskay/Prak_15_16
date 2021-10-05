package prak_15_16;

public class Robot {
    public Step leg_left = new Step(this,"LEFT");
    public Step leg_left2 = new Step(this,"LEFT2");
    public Step leg_right = new Step(this,"RIGHT");
    public Step leg_right2 = new Step(this,"RIGHT2");
    public Robot(){}

    public void stepping()
    {
        Thread step_left = new Thread(leg_left);
        Thread step_right = new Thread(leg_right);
        Thread step_right2 = new Thread(leg_right2);
        Thread step_left2 = new Thread(leg_left2);
        step_left.start();
        step_right.start();
        step_left2.start();
        step_right2.start();
    }

}
