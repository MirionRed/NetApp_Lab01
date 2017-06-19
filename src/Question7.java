

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Red King
 */
public class Question7 {
    public static void main(String[]args){
        ExecutorService executor = Executors.newCachedThreadPool();
        
        executor.execute(new WriteReadDelete("Write"));
        executor.execute(new WriteReadDelete("Read"));
        
        executor.shutdown();
    }
}

class WriteReadDelete implements Runnable{
    public static String FILENAME = "C:\\Users\\Red King\\My Documents\\NetBeansProjects\\NetworkApplication\\Practical1\\result.txt";
    private BufferedWriter bw = null;
    private BufferedReader br = null;
    private FileWriter fw = null;
    private FileReader fr = null;
    private String output;
    private final ReentrantLock lock = new ReentrantLock();
    private String operation;
    public WriteReadDelete(String operation){
        this.operation = operation;
    }
    
    public void WriteFile(){
        int count = 1;
        while(count == 1){
            lock.lock();
            try{
                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);
                output = br.readLine();
                if(output == null){
                    String content = "Written String";

                    fw = new FileWriter(FILENAME, true);
                    bw = new BufferedWriter(fw);
                    bw.write(content);
                    
                    System.out.println("Done Writing");
                    count = 0;
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
                try{
                    if(br != null)
                        br.close();
                    if(fr != null)
                        fr.close();
                    if(bw!=null)
                        bw.close();
                    if(fw!=null)
                        fw.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public void ReadFile(){
        int count = 1;
        while(count == 1){
            lock.lock();
            try{
                fr = new FileReader(FILENAME);
                br = new BufferedReader(fr);
                output = br.readLine();
                if(output != null){
                    System.out.println(output);
                    System.out.println("Done Reading");

                    String content = "";

                    fw = new FileWriter(FILENAME);
                    bw = new BufferedWriter(fw);
                    bw.write(content);

                    System.out.println("Done Deleting");
                    count = 0;
                }
            }catch (IOException e){
                e.printStackTrace();
            }finally{
                lock.unlock();
                try{
                    if(br != null)
                        br.close();
                    if(fr != null)
                        fr.close();
                    if(bw!=null)
                        bw.close();
                    if(fw!=null)
                        fw.close();
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run(){
        if(operation == "Read")
            ReadFile();
        else if(operation == "Write")
            WriteFile();
        else
            System.out.println("ERROR");
    }
}
