import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Person> integerQueue = new PriorityQueue<Person>(2);

        Person a = new Person("a", 1);
        Person b = new Person("b", 3);
        Person c = new Person("c", 2);

        integerQueue.add(a);
        integerQueue.add(b);
        integerQueue.add(c);

        Person poll = integerQueue.remove();

        System.out.println(poll.getAge());
    }


    public ArrayList<Integer> test(ArrayList<Integer> arr) {
        return arr;

    }


}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return o.getAge() - this.age;
    }
}