package dmcigd.core;

public class ThreadSync {
    
    // which thread is being waited for? -- currently sees no use
    public enum WaitingFor {
        /** The 'main thread' */
        OBJECTS, 
        /** The dedicated graphics thread. */
        GRAPHICS,
        /** The dedicated AI thread. */
        AI,
        /** The currently nonexistent dedicated physics thread. */
        PHYSICS
    }
    
    WaitingFor waitingFor;
    boolean valueSet = false;

    public synchronized void consume() {
        if (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
    }

    public synchronized void consumed() {

        valueSet = false;
        notify();
    }

    public synchronized void produce() {

        if (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }

    }

    public synchronized void produced() {

        valueSet = true;
        notify();
    }
}
