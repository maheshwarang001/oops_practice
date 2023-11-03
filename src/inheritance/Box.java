package inheritance;

public class Box {

    private double w;
    private double l;
    private double b;

    Box(){
        this.b = 1;
        this.w = 1;
        this.l = 1;
    }

    Box(double side){
        this.b = side;
        this.w = side;
        this.l = side;
    }

    Box(double b, double w, double l ){
        this.b = b;
        this.w = w;
        this.l = l;
    }

    Box(Box oldbox){
        this.b = oldbox.b;
        this.w = oldbox.w;
        this.l = oldbox.l;
    }

    public void getToString(){
        System.out.println("" + w + b + l);
    }

}
