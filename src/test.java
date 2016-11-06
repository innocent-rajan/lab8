
public class test {

	   public static void main(String args[]) {
	      final_class P1 = new final_class("Producer 1");
	      final_class P2 = new final_class("Producer 2");
	      final_class P3 = new final_class("Producer 3");
	      final_class C1 = new final_class("Customer 1");
	      final_class C2 = new final_class("Customer 2");
	      final_class C3 = new final_class("Customer 3");
	      final_class C4 = new final_class("Customer 4");
	      P1.start();
	      P2.start();
	      P3.start();
	      C1.start();
	      C2.start();
	      C3.start();	      
	   }   
	}