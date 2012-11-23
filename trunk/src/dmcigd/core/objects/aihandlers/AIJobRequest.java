/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dmcigd.core.objects.aihandlers;

/**
 * A teeny weeny message class, instances of which are passed back and forth 
 * between AIHandlers (which produce requests) and the AIJobScheduler (which 
 * delegates the computation to be solved, and sends back results).
 * @author filip
 */
public class AIJobRequest {
    
    public enum JobType {
        GETPATH, // requires a pathfind
        FINDTARGET, // requres a target-find
    }
    
    public JobType jobType;
    
    
    
    
}
