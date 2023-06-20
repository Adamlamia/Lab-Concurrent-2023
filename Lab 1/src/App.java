public class App {
    public static void main(String[] args) throws Exception {
        Runnable printWorld = new printHelloWorld();
        Runnable printNice = new printItsANiceDay();

        Thread thread1 = new Thread(printWorld);
        Thread thread2 = new Thread(printNice);

        thread1.start();
        thread2.start();

    }

    public static class printHelloWorld implements Runnable {
        public void run() {

            for (int i = 0; i < 30; i++)
                System.out.print("Hello World\n");
        }
    }

    public static class printItsANiceDay implements Runnable {
        public void run() {

            for (int i = 0; i < 15; i++)
                System.out.print("It`s a nice day\n");
        }
    }

}