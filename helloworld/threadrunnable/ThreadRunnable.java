package threadrunnable;

/**
 创建一个线程，最简单是创建一个实现Runnable接口的类
 为了实现 Runnable ，一个类只需要执行一个方法调用run()
 public void run()
 我们可以重写run 方法 ，run() 可以调用其他方法
 在创建一个Runnable 接口类后，可以在类中实例化一个线程对象

 Thread 定义了几个构造方法，下面是经常使用的
 Thread(Runnable threadOb,String threadName);
 threadOb是一个实现Runnable接口类的实例，threadName是新线程的名称
 新线程创建后，调用start() 运行
 void start();

 * */
class ThreadStart implements Runnable{
    private java.lang.Thread t; //定义一个线程
    private String threadName; //定义线程名称

    ThreadStart(String name){
        threadName = name;
        System.out.println("creating "+threadName);
    }

    public void run(){
        System.out.println("running "+threadName);
        try {
            for (int i = 4;i > 0;i--){
                System.out.println("thread "+threadName+", "+i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("error "+e.getMessage()+"; thread "+threadName+" interrupted");
        }
        System.out.println(("thread "+threadName+" exiting"));
    }

    public void start(){
        System.out.println("starting "+threadName);
        if(t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }
}

public class ThreadRunnable{
    public static void main(String args[]){
        ThreadStart R1 = new ThreadStart("thread-1");
        R1.start();

        ThreadStart R2 = new ThreadStart("thread-2");
        R2.start();
    }
}
