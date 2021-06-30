package demo1;

/**
 *
 */
public class SyncDemo {
    synchronized void method() {
    }


    synchronized static void method2() {
    }

    {
         Object a = new Object();
        synchronized (a){
        }
    }

    static {

    }

    void method3() {

    }

}
