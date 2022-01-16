public class Dog {
    int weightInPounds;

    public Dog(int w) {
        weightInPounds = w;
    }

    public void makeNoise() {
        if(weightInPounds < 10) {
            System.out.println("yark!");
        } else if (weightInPounds < 30) {
            System.out.println("wooooof!");
        } else {
            System.out.print("Bark!");
        }
    }

    public Dog maxDog(Dog d1, Dog d2) {
        if (weightInPounds > d2.weightInPounds) {
            return this;
        }
        return d2;
        
    }
}
