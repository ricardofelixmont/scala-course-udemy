package playground;

public class JavaPlayground {

    public static void main(String args[]) {

        System.out.println("Hello, Java");
        System.out.println(Person.N_EYES);
    }

}


class Person{
    /*
    This is the way we do in Java, to access some class Constant without needing an instance of this class.
        This is called 'class level functionality', and it's one of the fundamental aspects of object oriented programming
     */
    public static final int N_EYES = 2;

}
