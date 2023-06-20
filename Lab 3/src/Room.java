import java.util.concurrent.Semaphore;

public class Room {
    private Semaphore guestSemaphore = new Semaphore(6);
    private Semaphore cleanerSemaphore = new Semaphore(1);

    public void enterGuest() throws InterruptedException {
        guestSemaphore.acquire(); // acquire guest semaphore
        // critical section for guests
        System.out.println("Guest entered the room");
        Thread.sleep(1000); // simulate guest activity
        System.out.println("Guest left the room");
        guestSemaphore.release(); // release guest semaphore
    }

    public void enterCleaner() throws InterruptedException {
        cleanerSemaphore.acquire(); // acquire cleaner semaphore
        // critical section for cleaners
        System.out.println("Cleaner entered the room");
        Thread.sleep(1000); // simulate cleaning process
        System.out.println("Cleaner left the room");
        cleanerSemaphore.release(); // release cleaner semaphore
    }
}
