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
        notifyAll();
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
        notifyAll();
        return element;
    }

    public synchronized boolean isFull() {
        return data != null;
    }

}