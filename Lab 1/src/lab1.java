import java.security.cert.TrustAnchor;

public class lab1 {
    public static void main(String[] args) {
        PrintChar printChar = new PrintChar();
        PrintNum printNum = new PrintNum();

        printChar.start();
        printNum.start();

    }

    private static volatile int turn = 0;

    /**
     * PrintChar
     */
    public static class PrintChar extends Thread {
    
        public void run() {
            for (int i = 0; i < 10; i++) {
                while (turn != 0) {
                }
                System.out.println('A');
                    turn = 1;
            }
        }
    }

    /**
     * PrintNum
     */
    public static class PrintNum extends Thread{ 
    
        public void run() {
            for (int i = 1; i < 45; i++) {
                while (turn != 1) {
                }
                System.out.println(i);
                    turn = 0;
            }
        }
    }
}
