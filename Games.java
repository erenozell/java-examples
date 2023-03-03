public class Games {
    public static void main(String[] args) {
        Account account = new Account();
        account.addUser(new User("eren", "null", 24, "eren45", "manisa45"));
        account.addUser(new User("eren", "null", 24, "eren5", "manisa45"));
        account.showList();
        account.removeUser();
        account.showList();
    }
}
