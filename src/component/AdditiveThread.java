package component;

public class AdditiveThread implements Runnable {

    private final BoundedBlockingBuffer<String> buffer;

    public AdditiveThread(BoundedBlockingBuffer<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        System.out.println("Additive Thread");
        buffer.put("put");
        System.out.println("String was inserted to buffer");
    }

}
