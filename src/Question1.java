import java.util.Random;

public class Question1 {
    public static void main(String[]args){
        printNum1 task1 = new printNum1(1, 200);
        printWord1 task2 = new printWord1(1, 175);
        printWord1 task3 = new printWord1(2, 125);
        printNum1 task4 = new printNum1(1, 100);
        
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        Thread thread4 = new Thread(task4);
        
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

class printNum1 implements Runnable{
    int x;
    int times;
    Random ran = new Random();
    
    public printNum1(int x, int times){
        this.x = x;
        this.times = times;
    }
    
    public void MulOfSix(){
        System.out.print(ran.nextInt(10)*6 + " ");
    }
    
    public void randomNumber(){
        System.out.print(ran.nextInt(10) + " ");
    }
    
    public void run(){
        for(int i = 0; i < times; i++){
            if(x == 1){
                MulOfSix();
            }else{
                randomNumber();
            }
        }
    }
}

class printWord1 implements Runnable{
    int x;
    int times;
    Random ran = new Random();
    
    public printWord1(int x, int times){
        this.x = x;
        this.times = times;
    }
    
    public void U(){
        System.out.print("U ");
    }
    
    public void Meow(){
        System.out.print("Meow ");
    }
    
    public void run(){
        for(int i = 0; i < times; i++){
            if(x == 1){
                U();
            }else{
                Meow();
            }
        }
    }
}
