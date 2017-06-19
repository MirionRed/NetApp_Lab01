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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Question6 {
    public static void main(String[]args){
        ExecutorService executor = Executors.newCachedThreadPool();
        
        executor.execute(new ExplicitLocks("Meow"));
        executor.execute(new ExplicitLocks("Quack"));
        executor.execute(new ExplicitLocks("Woof"));
        executor.execute(new ExplicitLocks("Moo"));
        
        executor.shutdown();
    }
}

class ExplicitLocks implements Runnable{
    public static String FILENAME = "C:\\Users\\Red King\\My Documents\\NetBeansProjects\\NetworkApplication\\Practical1\\result.txt";
    private BufferedWriter bw = null;
    private FileWriter fw = null;
    private String output;
    private final ReentrantLock lock = new ReentrantLock();
    
    public ExplicitLocks(String output){
        this.output = output;
    }
    
    public void Meow(){
        lock.lock();
        try{
            String content = "Meow ";

            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println("Done Meow ");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
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
    
    public void Quack(){
        lock.lock();
        try{
            String content = "Quack ";

            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println("Done Quack ");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
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
    
    public void Woof(){
        lock.lock();
        try{
            String content = "Woof ";

            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println("Done Woof ");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
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
    
    public void Moo(){
        lock.lock();
        try{
            String content = "Moo ";

            fw = new FileWriter(FILENAME, true);
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println("Done Moo ");
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            lock.unlock();
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
