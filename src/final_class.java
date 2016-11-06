import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class final_class implements Runnable {
	   private Thread t;
	   private String threadName;
	   
	   final_class(String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName );
	      try {
	    	  FileReader file = new FileReader("temperature");
	          BufferedReader reader = new BufferedReader(file);  
	          String line = reader.readLine();
	          while(line!=null){
	        	  System.out.println(line);
	        	  line = reader.readLine();
	          }
	      }catch (IOException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	}

	