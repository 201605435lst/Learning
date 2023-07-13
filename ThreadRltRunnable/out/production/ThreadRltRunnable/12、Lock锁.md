# Lock（锁）

- 从JDK5.0开始，java提供了更强大的线程同步机制——通过显示定义同步锁对象来实现同步，同步锁使用Lock对象充当；
- java.util.concurrent.locks.Lock接口是控制多个线程对共享资源进行访问的工具，锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁，线程开始访问共享资源之前先获得Lock对象
- ReentrantLock类实现了Lock,它拥有synchronized相同的并发性和内存语义，在实现线程安全的过程中，比较常用的是ReenTrantLock,可以显示加锁，释放锁


## reentrantLock（可重复锁）

```
public class LockDemo01 {

    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"小张").start();
        new Thread(ticket,"小丽").start();
        new Thread(ticket,"小王").start();


    }

}

class Ticket implements Runnable{
    int tickNum=10;

   //定义Lock锁
   private final ReentrantLock reentrantLock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            if(tickNum<=0){
                System.out.println("当前票数为"+tickNum);
                return;
            }else{

                try{
                    //加锁
                    reentrantLock.lock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"拿到第"+tickNum--+"张票");
                }finally {
                    //解锁
                    reentrantLock.unlock();
                }


            }
        }
    }
}

```

# synchronized 与lock的对比

 - Lock是显示锁（手动开启和关闭锁，别忘记关闭锁），synchronized是隐使锁，处了作用域自动释放；
 - Lock只有代码块锁。synchronized有方法锁和代码块锁；
 - 使用Lock锁，JVM将花费较少的时间来调度线程，性能更好，并且具有更好的扩展性（提供更多的子类）；
 - 优先使用顺序
    Lock>同步代码块（已经进入了方法体，分配了相应资源）>同步方法（在方法体外）