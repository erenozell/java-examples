public class Test {

    public static void main(String[] args) {

        UserRepository repo = new UserRepository("gloriaJeans", 50);
        repo.addUser(null);
        repo.addUser(null);

        repo.addUser(null);

        repo = new UserRepository("pause", 20);

    }
}
