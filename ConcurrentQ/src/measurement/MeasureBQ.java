package measurement;

import bq.BoundedQ;

public class MeasureBQ implements Runnable {

	BoundedQ<Integer> bQ = new BoundedQ<Integer>();
	Thread enquerThread = new Thread(this);
	Thread dequerThread = new Thread(this);
	
	public MeasureBQ() {
		enquerThread.setName("enq");
		dequerThread.setName("deq");
	}
	
	public void startThreads(){
		enquerThread.start();
		dequerThread.start();
	}
	
	@Override
	public void run(){
		for(int i =0 ;i < 1000000 ; ++i){
			if(Thread.currentThread().getName().equalsIgnoreCase("enq")){
				bQ.enqMethod(new Integer(i+15));
//				System.out.println("Enqued : "+(i+15));
			}else{
				Integer p = bQ.deqMethod();
//				System.out.println("From Deq "+p.intValue());
			}
		}
	}
}
