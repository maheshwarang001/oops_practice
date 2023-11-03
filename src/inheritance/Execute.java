package inheritance;

public class Execute {
    public static void main(String[] args) {

        Box obj1 = new Box();
        obj1.getToString();

        Box obj2 = new Box(3);
        obj2.getToString();

        Box obj3 = new Box(3,4,1);
        obj2.getToString();

        Box obj4 = new Box(obj3);
        obj2.getToString();



    }
}
