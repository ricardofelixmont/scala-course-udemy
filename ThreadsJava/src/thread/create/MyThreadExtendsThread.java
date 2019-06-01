package thread.create;

public class MyThreadExtendsThread extends Thread {

    @Override
    public void run(){

        System.out.println(
                "Running Thread extended by Thread superclass..."

        );
    }
}
