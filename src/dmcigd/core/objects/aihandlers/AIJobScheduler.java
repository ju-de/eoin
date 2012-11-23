/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.aihandlers;

import java.util.*;

/**
 * The AIJobScheduler is responsible for queueing AI requests and sending back 
 * the results. The way it works is basically like an OS kernel's CPU threader, 
 * but much simpler and in java.
 * 
 * @author filip
 */
public class AIJobScheduler implements Runnable {
    
    private LinkedList<AIJobRequest> jobRequests = new LinkedList<AIJobRequest>();
    
    /**
     * Used by pithy AIHandlers to plead for some time from the all-mighty 
     * AIJobSheduler.
     * @param request 
     */
    public void addRequest(AIJobRequest request){
        jobRequests.add(request);
    }
    
    
    
    
    @Override
    public void run() {
        
        
        
        
        
    }
    
}
