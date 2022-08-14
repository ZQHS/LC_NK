public class CloneTest {
    public static void main(String[] args) {
        Dog d1 = new Dog("d1", 1, "green");
        Dog d2 = d1.clone();
        d2.setName("d2");
        // 可以看到修改了d2后，d1也改变了
        System.out.println("d1 name:" + d1.getName());
        System.out.println("d2 name:" + d2.getName());

    }
}

class Dog implements Cloneable {
    private String name;
    private int age;
    private String color;
    private Mao mao;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;

    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Mao getMao() {
        return mao;
    }

    public void setMao(Mao mao) {
        this.mao = mao;
    }


    @Override
    public Dog clone() {
        try {
            Dog clone = (Dog) super.clone();
            // TODO: 复制此处的可变状态，这样此克隆就不能更改初始克隆的内部项
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class Mao {
    private String changduan;
    private String color;

    public Mao(String changduan, String color) {
        this.changduan = changduan;
        this.color = color;
    }

    public String getChangduan() {
        return changduan;
    }

    public void setChangduan(String changduan) {
        this.changduan = changduan;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
