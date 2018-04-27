package stackandqueues;

public class CovariantCatsArray {

    private static void printCats() {
        Cat[] cats = new Cat[2];
        Animal[] animals = cats;
        cats[0] = new Cat();
        // тут в массив котов записываем собаку, обошли контроль типов
        animals[1] = new Dog(); // однако во время выполнения runtime получаем исключение ArrayStoreException
        System.out.println("test if we get here"); // до этой строки не дойдет
        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }

    public static void main(String[] args) {
        printCats();
    }
}

class Animal {

}

class Cat extends Animal {
    @Override
    public String toString() {
        return "Cat{}";
    }
}

class Dog extends Animal {
    @Override
    public String toString() {
        return "Dog{}";
    }
}
