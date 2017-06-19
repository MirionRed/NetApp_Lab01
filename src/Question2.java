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

public class Question2 {
    public static void main(String[]args){
        printNum2 task1 = new printNum2(1,200);
        printWord2 task2 = new printWord2(1, 175);
        printWord2 task3 = new printWord2(2, 125);
        printNum2 task4 = new printNum2(2,100);
        
        task1.start();
        task2.start();
        task3.start();
        task4.start();
    }
}

class printNum2 extends Thread{
    int x;
    int times;
    Random ran = new Random();
    
    public printNum2(int x, int times){
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

class printWord2 extends Thread{
    int x;
    int times;
    Random ran = new Random();
    
    public printWord2(int x, int times){
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

