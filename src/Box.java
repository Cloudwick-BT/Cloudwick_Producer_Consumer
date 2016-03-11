import java.util.LinkedList;

/**
 * 
 * @author Bhavin Tandel
 * @since  11/03/2016; 10:14
 */

public class Box {
	private LinkedList<String> messages ;
	private int queueSize;
	public boolean empty;
	
	public Box(){
		messages = new LinkedList<String>();
		queueSize = 5;
		empty = true;
	}
	
	public synchronized String take(){
		while(empty){
			try{
				wait();
			}catch (InterruptedException e) {
			}
		}
		notifyAll();
		String message= messages.remove();
		empty = messages.isEmpty();
		return message;
	}
	
	public synchronized void put(String message){
		while(this.messages.size() >= queueSize){
			try{
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.messages.add(message);
		empty = message.isEmpty();
		notifyAll();
	}

}
