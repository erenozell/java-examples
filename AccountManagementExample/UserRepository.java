
/*
 * UserRepository 
 * 
 * Bu sınıf User türünden objeleri depolar.
 * Constructor-> parametreler = userList (User[]) ve name (String) alır.
 * addUser-> Yeni user eklemek
 * getUserList-> User türündeki obje listesini verir.
 * deleteUser-> userList içerisindeki kullanıcıyı verilen username (String) siler. 
 */

public class UserRepository {
    private String name;
    private int index = 0;
    private User[] userList;

    // {null,null,null,...}
    // null,null,null
    // Obj, null,null,null

    UserRepository(String name, int length) {
        this.userList = new User[length];
        this.name = name;
    }

    public boolean addUser(User user) {
        if (index < userList.length) {
            userList[index] = user;
            index++;
            return true;
        } else
            return false;

    }

    public boolean removeUser(String username) {
        boolean isFound = false;
        User[] userListCopy = new User[userList.length];
        int tempI = 0;
        for (int i = 0; i <= index; i++) {
            if (username.toLowerCase() != userList[i].getUsername().toLowerCase()) {
                userListCopy[tempI] = userList[i];
                tempI++;
            } else {
                isFound = true;
            }

        }
        userList = userListCopy;
        return isFound;

    }

    public String getName() {
        return name;
    }

    public User[] getUserList() {
        return userList;
    }
}
