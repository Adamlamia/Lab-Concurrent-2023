public class example2 {
    public static void name() {

        printHelloWorld pWorld = new printHelloWorld();
        printItsANiceDay pANiceDay = new printItsANiceDay();

        pWorld.start();
        pANiceDay.start();
    }

    /**
     * printHelloWorld extends Thread
     */
    public static class printHelloWorld extends Thread {

        public void run() {
            for (int i = 0; i < 500; i++)
                System.out.print("Hello World");
        }
    }

    /**
     * Innerexample2
     */
    public static class printItsANiceDay extends Thread {

        public void run() {
            for (int i = 0; i < 300; i++)
                System.out.print("It`s a nice day");
        }
    }
}
