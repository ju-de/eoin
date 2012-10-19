package dmcigd.core;

public class ThreadSync {
	
	boolean valueSet = false; 
	
	public synchronized void consume() { 
		if(!valueSet) try { 
			wait(); 
		} catch(InterruptedException e) { 
			System.out.println("InterruptedException caught"); 
		}
	}
	
	public synchronized void consumed() { 
		
		valueSet = false; 
		notify(); 
	}
	
	public synchronized void produce() {
		
		if(valueSet) try { 
			wait(); 
		} catch(InterruptedException e) { 
			System.out.println("InterruptedException caught"); 
		}
		
	}
	
	public synchronized void produced() { 
		
		valueSet = true; 
		notify(); 
	}
}
