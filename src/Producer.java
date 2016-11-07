import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Producer implements Runnable {
	private final String name;
	private final Vector<Double> sharedQueue;
    private final int number;

    public Producer(Vector<Double> al, int number,String name) {
        this.sharedQueue = al;
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
    	switch(this.number){
    	case 1 :{
    	try {
            int a=0;
            	FileReader file = new FileReader("temperature");
            	BufferedReader reader = new BufferedReader(file);  
            	String line = reader.readLine();
            	System.out.println('\n');
            	synchronized(sharedQueue){
            		while(line!=null){
            			double v;
            			v=Double.parseDouble(line);
            			produce(v);
            			line = reader.readLine();
            			a++;
            			if (a==100)
            				break;
		       	  		}
            		}
            }catch (IOException e) {
            	System.out.println("Thread interrupted.");
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
    	break;
        }
    	case 2 :{
        	try {
                int a=0;
                	FileReader file = new FileReader("humidity");
                	BufferedReader reader = new BufferedReader(file);  
                	String line = reader.readLine();
                	System.out.println('\n');
                	synchronized(sharedQueue){
                		while(line!=null){
                			double v;
                			v=Double.parseDouble(line);
                			produce(v);
                			line = reader.readLine();
                			a++;
                			if (a==100)
                				break;
    		       	  		}
                		}
                }catch (IOException e) {
                	System.out.println("Thread interrupted.");
                } catch (InterruptedException e) {
                	e.printStackTrace();
                }
        	break;
            }
    	case 3 :{
        	try {
                int a=0;
                	FileReader file = new FileReader("rainfall");
                	BufferedReader reader = new BufferedReader(file);  
                	String line = reader.readLine();
                	System.out.println('\n');
                	synchronized(sharedQueue){
                		while(line!=null){
                			double v;
                			v=Double.parseDouble(line);
                			produce(v);
                			line = reader.readLine();
                			a++;
                			if (a==100)
                				break;
    		       	  		}
                		}
                }catch (IOException e) {
                	System.out.println("Thread interrupted.");
                } catch (InterruptedException e) {
                	e.printStackTrace();
                }
        	break;
            }
    }
    System.out.println("Thread exiting.");
}
    private void produce(double v) throws InterruptedException {
        while (sharedQueue.size() == 100) {
                sharedQueue.wait();
            }

        //producing element and notify consumers
        synchronized (sharedQueue) {
            sharedQueue.add(v);
            sharedQueue.notifyAll();
        }
    }
}


