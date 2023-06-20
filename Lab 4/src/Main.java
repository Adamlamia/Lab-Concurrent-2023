public class Main {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(-1);
        Write writeThread = new Write(node);
        Operate operateThread = new Operate(node, 3, new Dummy());

        new Thread(writeThread).start(); //rewrite the value
        new Thread(operateThread).start(); //checking return value

    
    }
}
