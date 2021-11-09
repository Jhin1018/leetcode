public class DeadLock {
    final Object A = new Object();
    final Object B = new Object();

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                synchronized (dl.A){
                    System.out.println("线程1已经拿到A");
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    synchronized (dl.B){
                        System.out.println("线程1开始运行");
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                synchronized (dl.B){
                    System.out.println("线程2已经拿到B");
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    synchronized (dl.A){
                        System.out.println("线程2开始运行");
                    }
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
