package Thread;

public class Test extends Thread{
    @Override
    public void run() {
        System.out.println("hello world");
    }

    @Override
    public synchronized void start() {
        super.start();
        System.out.println("qqq");
    }

    public static void main(String[] args) {
        Test t=new Test();
        t.start();
        System.out.println();
    }
}
