import java.util.LinkedList;

public class LeetCode641 {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.size);
        boolean b = myCircularDeque.insertLast(1);
        System.out.println(b);

    }

}

class MyCircularDeque {

    int size;
    LinkedList<Integer> list = new LinkedList<>();

    public MyCircularDeque(int k) {
        this.size = k;
    }

    public boolean insertFront(int value) {
        if (list.size() == size) {
            return false;
        } else {
            list.add(0, value);
            return true;
        }
    }

    public boolean insertLast(int value) {
        if (list.size() == size) {
            return false;
        } else {
            list.add(value);
            return true;
        }
    }

    public boolean deleteFront() {
        if (list.isEmpty()) {
            return false;
        } else {
            list.remove();
            return true;
        }
    }

    public boolean deleteLast() {
        if (list.isEmpty()) {
            return false;
        } else {
            list.removeLast();
            return true;
        }
    }

    public int getFront() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.getFirst();
        }
    }

    public int getRear() {
        if (list.isEmpty()) {
            return -1;
        } else {
            return list.getLast();
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == size;
    }
}