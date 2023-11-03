package singleton;

public class Main {
    public static void main(String[] args) {

        Singleton obj1 = Singleton.getInstance(1);
        Singleton obj2 = Singleton.getInstance(3);
        Singleton obj3 = Singleton.getInstance(2);

        System.out.println(obj1.getNumber());
        System.out.println(obj2.getNumber());
        System.out.println(obj3.getNumber());
    }
}