import component.AdditiveThread;
import component.BoundedBlockingBuffer;
import component.RecipientThread;

public class Main {
    private static final BoundedBlockingBuffer<String> buffer = new BoundedBlockingBuffer<>();

    public static void main(String[] args) {

        AdditiveThread additiveThread = new AdditiveThread(buffer);
        RecipientThread recipientThread = new RecipientThread(buffer);
        Thread additive = new Thread(additiveThread);
        Thread recipient = new Thread(recipientThread);
        additive.start();
        recipient.start();

    }

}
