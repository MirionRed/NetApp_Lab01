/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Red King
 */
import java.util.Random;
import java.util.concurrent.*;


public class Question3 {
    public static void main(String[]args){
         ExecutorService executor = Executors.newFixedThreadPool(4);
    
        executor.execute(new printNum3(1, 200));
        executor.execute(new printWord3(1, 175));
        executor.execute(new printWord3(2, 125));
        executor.execute(new printNum3(1, 100));
        
        executor.shutdown();
    }
}

class printNum3 implements Runnable{
    int x;
    int times;
    Random ran = new Random();
    
    public printNum3(int x, int times){
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

class printWord3 implements Runnable{
    int x;
    int times;
    Random ran = new Random();
    
    public printWord3(int x, int times){
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