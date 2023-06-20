public class MainRoom {
    public static void main(String[] args) {
        Room room = new Room();

        // simulate guest threads
        for (int i = 0; i < 10; i++) {
            Thread guestThread = new Thread(() -> {
                try {
                    room.enterGuest();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            guestThread.start();
        }

        // simulate cleaner threads
        for (int i = 0; i < 5; i++) {
            Thread cleanerThread = new Thread(() -> {
                try {
                    room.enterCleaner();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            cleanerThread.start();
        }
    }
}

