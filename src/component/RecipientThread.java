package component;

public class RecipientThread implements Runnable {

    private final BoundedBlockingBuffer<String> buffer;

    public RecipientThread(BoundedBlockingBuffer<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("______________________________");
        System.out.println("Recipient Thread");
        System.out.println("Buffered value is " + buffer.take());
        System.out.println("String was taken from buffer");
    }

}
