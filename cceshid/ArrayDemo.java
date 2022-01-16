public class ArrayDemo {
    public static void main(String[] args) {
        Dog[] dogs = new Dog[10];
        dogs[6] = new Dog(8);
        System.out.println(dogs[6].weightInPounds);
        dogs[6].makeNoise();
    }
}
