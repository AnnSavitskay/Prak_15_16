package prak_15_16_part2;


public class Work_ATM implements Runnable{
    Person person;
    public int sum, subtract;
    int sleep;
    public Work_ATM(int sum, int subtract, Person person, int sleep)
    {
        this.sum = sum;
        this.subtract = subtract;
        this.person = person;
        this.sleep = sleep;
    }

    public void run()
    {
        while (true)
        {
            synchronized (Terminal.monitor)
            {
                try {
                    this.Add();
                    this.Subtract();
                    if(person.getBalance() < 0) throw new Exception();
                } catch (Exception e) {
                    System.out.println("Balance is not enough");
                }

                System.out.println(person.toString());
                Terminal.monitor.notify();
                try {
                    Terminal.monitor.wait();
                    Thread.sleep(sleep);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Add()
    {
        person.setBalance(sum + person.getBalance());
    }

    public void Subtract()
    {
        person.setBalance(person.getBalance() - subtract);
    }
}
