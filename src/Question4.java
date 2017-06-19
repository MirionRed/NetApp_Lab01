/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Red King
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Question4 {
    public static void main(String[] args){
        SynchronizedPrintMethod sp1 = new SynchronizedPrintMethod("Meow");
        SynchronizedPrintMethod sp2 = new SynchronizedPrintMethod("Quack");
        SynchronizedPrintMethod sp3 = new SynchronizedPrintMethod("Woof");
        SynchronizedPrintMethod sp4 = new SynchronizedPrintMethod("Moo");
        
        sp1.start();
        sp2.start();
        sp3.start();
        sp4.start();
    }
}

class SynchronizedPrintMethod extends Thread{
    public static String FILENAME = "C:\\Users\\Red King\\My Documents\\NetBeansProjects\\NetworkApplication\\Practical1\\result.txt";
    private BufferedWriter bw = null;
    private FileWriter fw = null;
    private String output;
    
    public SynchronizedPrintMethod(String output){
        this.output = output;
    }
    
    public synchronized void Meow(){
        try{
            String content = "Meow ";
            
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            bw.write(content);
            
            System.out.println("Done Meow ");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bw!=null)
                    bw.close();
                if(fw!=null)
                    fw.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public synchronized void Quack(){
        try{
            String content = "Quack ";
            
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            bw.write(content);
            
            System.out.println("Done Quack ");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bw!=null)
                    bw.close();
                if(fw!=null)
                    fw.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public synchronized void Woof(){
        try{
            String content = "Woof ";
            
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            bw.write(content);
            
            System.out.println("Done Woof ");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bw!=null)
                    bw.close();
                if(fw!=null)
                    fw.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public synchronized void Moo(){
        try{
            String content = "Moo ";
            
            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            bw.write(content);
            
            System.out.println("Done Moo ");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bw!=null)
                    bw.close();
                if(fw!=null)
                    fw.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void run(){
        if(output == "Meow"){
            Meow();
        }else if(output == "Quack"){
            Quack();
        }else if(output == "Woof"){
            Woof();
        }else{
            Moo();
        }
    }
}
