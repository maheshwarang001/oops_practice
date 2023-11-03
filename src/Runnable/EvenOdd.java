package Runnable;

public class EvenOdd implements Runnable{

    static int count = 1;
    Object obj;

    public EvenOdd(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {

        while(count <= 50){

            if(count%2 == 0 && Thread.currentThread().getName().equals("even")){
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName() + " " + count);
                    count++;
                    try {
                        obj.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            if(count%2 != 0 && Thread.currentThread().getName().equals("odd")){
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName() + " " + count);
                    count++;
                    try {
                        obj.notify();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}

class main {
    public static void main(String[] args) {
        Object obj = new Object();
        Runnable evenOdd1 = new EvenOdd(obj);
        Runnable evenOdd2 = new EvenOdd(obj);

        new Thread(evenOdd1,"even").start();
        new Thread(evenOdd2,"odd").start();


    }
}
