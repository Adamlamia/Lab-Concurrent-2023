import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StackAccessDriver {
    public static void main(String[] args) {
        StackAccess stackAccess = new StackAccess();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        /* Scenario 1: Only push tasks
        System.out.println("Only one push task");
        executor.execute(new WriteStack(stackAccess));
        */
        //Scenario 2: Push and pop tasks
        System.out.println("Push and Pop task");
        for (int i = 0; i < 3; i++) {
            
            executor.execute(new WriteStack(stackAccess));
        }
        executor.execute(new ReadStack(stackAccess));
        /* 
        //Scenario 3: Push, pop, and peek tasks
        System.out.println("Push, Pop and Peek task");
        executor.execute(new WriteStack(stackAccess));
        executor.execute(new ReadStack(stackAccess));
        executor.execute(new PeekStack(stackAccess));
        /* 
        //Scenario 4: Produce more data than consumed
        System.out.println("Push More than Pop");
        for (int i = 0; i < 5; i++) {
            executor.execute(new WriteStack(stackAccess));
        }
        for (int i = 0; i < 2; i++) {
            executor.execute(new ReadStack(stackAccess));
        }
        executor.execute(new PeekStack(stackAccess));
        /*
        // Scenario 5: Consume more data than produced
        System.out.println("Only one push task");
        for (int i = 0; i < 2; i++) {
            executor.execute(new WriteStack(stackAccess));
        }
        for (int i = 0; i < 5; i++) {
            executor.execute(new ReadStack(stackAccess));
        }
        executor.execute(new PeekStack(stackAccess));
        */
        executor.shutdown();
    }
}
