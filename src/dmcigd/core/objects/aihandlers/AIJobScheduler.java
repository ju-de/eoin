/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.aihandlers;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The AIJobScheduler is responsible for queueing AI requests and sending back 
 * the results. The way it works is basically like an OS kernel's CPU threader, 
 * but much simpler and in java.
 * 
 * @author filip
 */
public class AIJobScheduler implements Runnable {
    
    private LinkedList<AIJobRequest> jobRequests = new LinkedList<AIJobRequest>();
    private boolean awake = false;
    
    public PathComputer pathComputer = new PathComputer();
    
    
    /**
     * Used by pithy AIHandlers to plead for some time from the all-mighty 
     * AIJobSheduler.
     * @param request 
     */
    public synchronized void addRequest(AIJobRequest request){
        jobRequests.add(request);
        awake = true;
    }
    public synchronized boolean isAwake(){
        return awake;
    }
    
    
    /**
     * Runs the Scheduler and with it the AI thread, which sleeps if unneeded, 
     * and does sexy black magic otherwise.
     */
    @Override
    public void run() {
        while (true){
            // keep the Scheduler from eating up cpu
            if (!isAwake()){
                try {
                    Thread.sleep(50);
                    continue;
                } catch (InterruptedException ex) {
                    awake = true;
                }
            }
            
            // Pulls a request off of the queue, 
            
        }
        
        
    }
    
    // 
    public void parseNextRequest(){
        
        
        
        
    }
}
