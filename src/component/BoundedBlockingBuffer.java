package component;

public class BoundedBlockingBuffer<T> {

    private T data;

    public BoundedBlockingBuffer() {
    }

    public synchronized void put(T object) {
        try {
            while (data != null) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data = object;
        notify();
    }

    public synchronized T take() {
        try {
            while (data == null) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T element = data;
        data = null;
        notify();
        return element;
    }

}