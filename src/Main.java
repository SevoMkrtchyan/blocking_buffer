import component.BoundedBlockingBuffer;

public class Main {


    public static void main(String[] args) {

        BoundedBlockingBuffer<String> buffer = new BoundedBlockingBuffer<>();

        while (!buffer.isFull()) {
            buffer.put("1 put");
            System.out.println("Element added to buffer put");
        }

        while (buffer.isFull()) {
            String value = buffer.take();
            System.out.println("1 Take, Element taken from buffer : "
                    + value);
        }

        while (buffer.isFull()) {
            String value = buffer.take();
            System.out.println("2 Take, element taken from buffer : "
                    + value);
        }

        while (!buffer.isFull()) {
            buffer.put("2 put");
            System.out.println("Element added to buffer put");
        }

        while (!buffer.isFull()) {
            buffer.put("3 put");
            System.out.println("Element added to buffer put");
        }

        while (buffer.isFull()) {
            String value = buffer.take();
            System.out.println("3 Take, element taken from buffer : "
                    + value);
        }

    }

}
