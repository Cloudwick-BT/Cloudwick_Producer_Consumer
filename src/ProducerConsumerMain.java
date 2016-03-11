import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumerMain {
	public static void main(String[] args){
		//Box box = new Box();
		
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
		
		Thread p = (new Thread(new Producer(queue)));
		Thread c = (new Thread(new Consumer(queue)));
		Thread p1 = (new Thread(new Producer(queue)));
		Thread c1 = (new Thread(new Consumer(queue)));
		//Thread p2 = (new Thread(new Producer(box)));
		//Thread c2 = (new Thread(new Consumer(box)));
		
		p.start();
		c.start();
		p1.start();
		c1.start();
		//p2.start();
		//c2.start();
		
		
	}
	

}
