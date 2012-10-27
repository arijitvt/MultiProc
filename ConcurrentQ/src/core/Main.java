package core;

import bq.BoundedQ;
import measurement.MeasureBQ;
import measurement.MeasureSyncQ;

public class Main {
	public static void measureBQ(){
		BoundedQ<Integer> bQ = new BoundedQ<Integer>();
		for(int i = 0 ; i< 15; i++){
			bQ.enqMethod(new Integer(i));
		}
		long start = System.nanoTime();
		MeasureBQ mbq = new MeasureBQ();
		mbq.startThreads();
		long end = System.nanoTime();
		System.out.println("Total time of execution : "+(end-start));	
	}
	
	public static void measureSyncQ(){
		long startTime = System.nanoTime();
		MeasureSyncQ msQ = new MeasureSyncQ();
		msQ.startThreads();
		long endTime = System.nanoTime();
		System.out.println("Total time of execution : "+(endTime-startTime));
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		measureSyncQ();
	}
}