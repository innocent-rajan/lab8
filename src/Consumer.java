import java.util.Vector;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable{
	private final String name;
	private final Vector<Double> sharedQueue;
    private final int number;

    public Consumer(Vector<Double> al, int number,String name) {
        this.sharedQueue = al;
        this.name = name;
        this.number = number;
    }
	
	public void run() {
		System.out.println("Starting "+name);
		while (true) {
            try {
                consume();
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
	}

	private void consume() throws InterruptedException {
        synchronized (sharedQueue) {
        	sharedQueue.wait();
            sharedQueue.notifyAll();
            System.out.println("Starting "+name);
    		int a=0;
    		switch(this.number){
    			case 1:{
					System.out.println("Running " +  name );
					Object obj = Collections.min(sharedQueue);  
					System.out.println("Min :"+obj);
					break;
				}
    			case 2:{
    				System.out.println("Running " +  name );
    				Object obj = Collections.max(sharedQueue);
    				System.out.println("Max :"+obj);
    			    break;
    			}
    			case 3:{
    				System.out.println("Running " +  name );
    				double sum = 0,avg = 0;
    				for(int i =0;i<sharedQueue.size();++i){
    					sum+=sharedQueue.get(i);
    				}
    				avg=sum/sharedQueue.size();
    				System.out.println("Avg :"+avg);
    			    break;
    			}
    		}
        }
	}
}