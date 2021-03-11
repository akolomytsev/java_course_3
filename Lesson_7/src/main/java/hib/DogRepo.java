package hib;

public class DogRepo extends Repo<Dog>{

    public DogRepo(DataSource dataSource) {
        super(dataSource);
    }
}
