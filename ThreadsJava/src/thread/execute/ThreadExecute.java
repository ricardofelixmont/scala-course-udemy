package thread.execute;

import thread.create.MyThreadExtendsThread;
import thread.create.MyThreadImplementesRunnable;

public class ThreadExecute {

    public static void main(String[] args) {
        Thread t = new Thread(new MyThreadImplementesRunnable());
        MyThreadExtendsThread t1 = new MyThreadExtendsThread();

        t.start();
        t1.start();


    }
}
