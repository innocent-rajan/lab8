import java.util.Vector;
import java.util.Vector;

public class test {

	   public static void main(String args[]) throws InterruptedException {
		  Vector<Double> al=new Vector<Double>();
	      Thread P1 = new Thread(new Producer(al, 1, "Producer 1"), "Producer 1");
	      Thread P2 = new Thread(new Producer(al, 2, "Producer 2"), "Producer 2");
	      Thread P3 = new Thread(new Producer(al, 3, "Producer 3"), "Producer 3");
	      Thread C1 = new Thread(new Consumer(al, 1, "Consumer 1"), "Consumer 1");
	      Thread C2 = new Thread(new Consumer(al, 2, "Consumer 2"), "Consumer 2");
	      Thread C3 = new Thread(new Consumer(al, 3, "Consumer 3"), "Consumer 3");
	      //Thread C4 = new Thread(new Consumer(al, 4, "Consumer 4"), "Consumer 4");
	      //P1.start();
	      P1.start();
	      C1.start();
	      C2.start();
	      C3.start();
	      //C4.start();
	   }   
	}
