import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StackAccessDriver {

    public static void main(String[] args) {
        // Test scenario 1: Only push task
        System.out.println("Test scenario 1: Only push task");
        StackAccess stackAccess1 = new StackAccess(3);
        WriteStack writeStack1 = new WriteStack(stackAccess1);
        ExecutorService executorService1 = Executors.newFixedThreadPool(1);
        executorService1.submit(writeStack1);
        executorService1.shutdown();

        // Test scenario 2: Two types of task: push and pop
        System.out.println("Test scenario 2: Two types of task: push and pop");
        StackAccess stackAccess2 = new StackAccess(3);
        WriteStack writeStack2 = new WriteStack(stackAccess2);
        ReadStack readStack2 = new ReadStack(stackAccess2);
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService2.submit(writeStack2);
        executorService2.submit(readStack2);
        executorService2.shutdown();

        // Test scenario 3: Three types of task
        System.out.println("Test scenario 3: Three types of task");
        StackAccess stackAccess3 = new StackAccess(3);
        WriteStack writeStack3 = new WriteStack(stackAccess3);
        ReadStack readStack3 = new ReadStack(stackAccess3);
        PeekStack peekStack3 = new PeekStack(stackAccess3);
        ExecutorService executorService3 = Executors.newFixedThreadPool(3);
        executorService3.submit(writeStack3);
        executorService3.submit(readStack3);
        executorService3.submit(peekStack3);
        executorService3.shutdown();
/*
        // Test scenario 4: Produce more data than it is consumed
        System.out.println("Test scenario 4: Produce more data than it is consumed");
        StackAccess stackAccess4 = new StackAccess(3);
        WriteStack writeStack4 = new WriteStack(stackAccess4);
        ReadStack readStack4 = new ReadStack(stackAccess4);
        ExecutorService executorService4 = Executors.newFixedThreadPool(2);
        executorService4.submit(writeStack4);
        executorService4.submit(readStack4);
        executorService4.shutdown();

        // Test scenario 5: Consume more data than it is produced
        System.out.println("Test scenario 5: Consume more data than it is produced");
        StackAccess stackAccess5 = new StackAccess(3);
        ReadStack readStack5 = new ReadStack(stackAccess5);
        ExecutorService executorService5 = Executors.newFixedThreadPool(2);
        executorService5.submit(readStack5);
        executorService5.submit(readStack5);
        executorService5.shutdown();
 
        // Wait for all tasks to complete
        while (!executorService1.isTerminated() || !executorService2.isTerminated() || !executorService3.isTerminated()
                || !executorService4.isTerminated() || !executorService5.isTerminated()) {
            // do nothing
        }
        */
    }

}
