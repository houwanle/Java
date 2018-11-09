/*
   实例化三个线程，一个线程打印a，一个线程打印b，一个线程打印c，三个线程同时执行，
   要求打印出10个连着的abc。
   
   输出：
 abcabcabcabcabcabcabcabcabcabc
*/
import java.util.concurrent.atomic.AtomicInteger;
	
public class Test1 {
	public static void main(String args[]) {
		AtomicInteger synObj = new AtomicInteger(0);
		TestPrint a = new TestPrint(synObj, "a", 0);
		TestPrint b = new TestPrint(synObj, "b", 1);
		TestPrint c = new TestPrint(synObj, "c", 2);
		a.start();
		b.start();
		c.start();
	}
}	

class TestPrint extends Thread {
	private AtomicInteger synObj;
	private String name;
	private int flag;
	private int count = 0;
	
	public TestPrint(AtomicInteger synObj, String name, int flag) {		
		this.synObj = synObj;		
		this.name = name;		
		this.flag = flag;	
	}

	public void run() {		
		while (true) {			
			synchronized (synObj) {				
				if (synObj.get() % 3 == flag) {					
					synObj.set(synObj.get() + 1);					
					System.out.print(name);					
					count++;					
					synObj.notifyAll();					
					if (count == 10) {						
						break;					
					}				
				} else {					
					try {						
						synObj.wait();					
					} catch (InterruptedException e) {						
						e.printStackTrace();					
					}				
				}			
			}
		}
	}
}
