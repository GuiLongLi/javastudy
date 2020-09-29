package threadthread;

/**
 Thread 方法
 下表列出了Thread类的一些重要方法：

 序号	方法描述
 1	public void start()
 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
 2	public void run()
 如果该线程是使用独立的 Runnable 运行对象构造的，则调用该 Runnable 对象的 run 方法；否则，该方法不执行任何操作并返回。
 3	public final void setName(String name)
 改变线程名称，使之与参数 name 相同。
 4	public final void setPriority(int priority)
 更改线程的优先级。
 5	public final void setDaemon(boolean on)
 将该线程标记为守护线程或用户线程。
 6	public final void join(long millisec)
 等待该线程终止的时间最长为 millis 毫秒。
 7	public void interrupt()
 中断线程。
 8	public final boolean isAlive()
 测试线程是否处于活动状态。
 测试线程是否处于活动状态。 上述方法是被Thread对象调用的。下面的方法是Thread类的静态方法。

 序号	方法描述
 1	public static void yield()
 暂停当前正在执行的线程对象，并执行其他线程。
 2	public static void sleep(long millisec)
 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。
 3	public static boolean holdsLock(Object x)
 当且仅当当前线程在指定的对象上保持监视器锁时，才返回 true。
 4	public static Thread currentThread()
 返回对当前正在执行的线程对象的引用。
 5	public static void dumpStack()
 将当前线程的堆栈跟踪打印至标准错误流。
 * **/

class ThreadStart extends Thread{
    private Thread t;
    private String threadName;

    ThreadStart(String name){
        threadName = name;
        System.out.println("creating "+threadName);
    }

    public void run(){
        System.out.println("running "+threadName);
        try {
            for(int i = 4;i > 0;i--){
                System.out.println("thread "+threadName+", "+i);
                Thread.sleep(50);
            }
        }catch (InterruptedException e){
            System.out.println("error "+ e.getMessage()+ "; thread "+threadName+"interrupted");
        }
        System.out.println("thread "+threadName+" exiting");
    }

    public void start(){
        System.out.println("starting "+threadName);
        if(t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }
}

public class ThreadThread {
    public static void main(String args[]){
        ThreadStart T1 = new ThreadStart("thread-1");
        T1.start();

        ThreadStart T2 = new ThreadStart("thread-2");
        T2.start();
    }
}
