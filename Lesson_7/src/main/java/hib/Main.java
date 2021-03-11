package hib;

public class Main {

    private static DogRepo dogRepo = new DogRepo(new DataSource());
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog();
        dog.setName("Maylo");
        dog.setAge(2);
        dogRepo.createEntity(dog);
    }
}
