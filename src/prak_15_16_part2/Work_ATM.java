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
        this.work();
    }

    public synchronized void work()
    {
        while (true)
        {
                try {
                    this.Add();
                    this.Subtract();
                    if(person.getBalance() < 0) throw new Exception();
                    System.out.println(Thread.currentThread().getName() + " " + person.toString());
//                    Terminal.monitor.notify();

//                    Terminal.monitor.wait();
                    Thread.sleep(sleep);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                    break;
                }
                catch (Exception e) {
                    System.out.println("Balance is not enough");
                    Thread.currentThread().interrupt();
                    break;
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
