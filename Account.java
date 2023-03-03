import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Account {
    Scanner scan = new Scanner(System.in);
    private List<User> userList = new ArrayList<>();

    public boolean containsName(final String name) {
        return userList.stream().filter(user -> user.getUsername().equals(name)).findFirst().isPresent();
    }

    public User getUserObj(final String username) {
        return userList.stream().filter(user -> user.getUsername().equals(username)).findFirst().get();
    }

    public boolean addUser(User user) {
        if (user.getAge() > 13 && !containsName(user.getUsername())) {
            userList.add(user);
            return true;
        }
        return false;
    }

    public void showList() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getUsername());
        }
    }

    public boolean removeUser(String username) {
        if (containsName(username)) {
            User foundUser = getUserObj(username);
            userList.remove(foundUser);
        }
        return false;
    }

    public boolean updateUser(String username) {
        Scanner yen = new Scanner(System.in);
        if (containsName(username)) {
            int i = userList.indexOf(getUserObj(username));
            System.out.println("-0) first name\n-1) last name\n-2) age\n-3) username\n-4) password");
            int number = scan.nextInt();
            if (number == 0) {
                System.out.println("new first name : ");
                String nfn = yen.nextLine();
                userList.get(i).setFirstName(nfn);
            }

            else if (number == 1) {
                System.out.println("new last name : ");
                String nln = yen.nextLine();
                userList.get(i).setLastName(nln);
            }

            else if (number == 2) {
                System.out.println("new age : ");
                int na = yen.nextInt();
                userList.get(i).setAge(na);
            }

            else if (number == 3) {
                System.out.println("new  username : ");
                String nun = yen.nextLine();
                userList.get(i).setUsername(nun);
            }

            else if (number == 4) {
                System.out.println("new password : ");
                String np = yen.nextLine();
                userList.get(i).setPassword(np);
            }

            return true;
        }
        return false;

    }

    public boolean removeUser() {
        System.out.println("Lütfen kullanıcı adınızı giriniz : ");
        String username = scan.nextLine();
        int i = userList.indexOf(getUserObj(username));
        System.out.println("Lütfen parolanızı giriniz : ");
        String password = scan.nextLine();
        if (password.equals(userList.get(i).getPassword())) {
            userList.remove(i);
            return true;
        }
        return false;
    }

}