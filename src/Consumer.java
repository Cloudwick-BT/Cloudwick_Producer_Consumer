import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.*;


public class Consumer implements Runnable {

	BlockingQueue queue;
	
	public Consumer(BlockingQueue queue){
		this.queue = queue;
	}
	
	public void run(){
		String message = "";
		Random rnd = new Random();
				
		do{
			
			try{
				message = (String) queue.remove();
				System.out.println(message);
			}catch (NoSuchElementException e){}
			
			
			try {
				
				Thread.sleep(Math.abs(rnd.nextInt(500)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(!((message).equals("DONE")));
	}
}
