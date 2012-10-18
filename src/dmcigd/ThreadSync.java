package dmcigd;

public class ThreadSync {
	
	boolean valueSet = false; 
	
	synchronized void consume() { 
		if(!valueSet) try { 
			wait(); 
		} catch(InterruptedException e) { 
			System.out.println("InterruptedException caught"); 
		}
		
		valueSet = false; 
		notify(); 
	}
	
	synchronized void produced() { 
		if(valueSet) try { 
			wait(); 
		} catch(InterruptedException e) { 
			System.out.println("InterruptedException caught"); 
		}
		
		valueSet = true; 
		notify(); 
	}
}
