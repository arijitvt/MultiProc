package measurement;

import syncq.SyncQ;

public class MeasureSyncQ implements Runnable{
	Thread enqThread;
	Thread deqThread;
	SyncQ<Integer> synQ ;
	
	public MeasureSyncQ() {
		// TODO Auto-generated constructor stub
		enqThread = new Thread(this);
		deqThread = new Thread(this);
		enqThread.setName("enq");
		deqThread.setName("deq");
		synQ = new SyncQ<Integer>();
	}

	public void startThreads(){
		enqThread.start();
		deqThread.start();
	}
	
	
	@Override
	public void run(){
		for(int i = 0 ;i < 1000000;  ++i){
			if(Thread.currentThread().getName().equalsIgnoreCase("enq")){
				synQ.enq(new Integer(i));
				System.out.println("Enqued :"+i);
			}else{
				Integer data = synQ.deq();
				System.out.println("Deq : "+ data);
			}
		}
	}
}
