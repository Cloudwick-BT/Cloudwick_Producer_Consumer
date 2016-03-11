import java.util.Random;
import java.util.concurrent.*;

/**
 * 
 * @author Bhavin Tandel
 * @since  10/03/2016; 12:51
 */
public class Producer implements Runnable {
	BlockingQueue queue;
	
	public Producer(BlockingQueue queue){
		this.queue = queue;

	}
	
	public void run(){
		String[] strArray = {"The", "Lazy", "Fox", "Jumps", "Over", "Brown", "Dog"};
		Random rnd = new Random();
		for (String str : strArray){
			try {
				queue.put(str);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {

				Thread.sleep(Math.abs(rnd.nextInt(500)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			queue.put("DONE");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
