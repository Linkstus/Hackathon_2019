import java.util.*;
import java.io.*;

public class hackathon2 {

    File userFile = new File("C:\\Users\\carso\\source\\repos\\hackathon2\\users.txt");
    PrintWriter userStorage = new PrintWriter(userFile);
    Scanner scan = new Scanner(userFile);

    public void createUser(String username, String email, String password) throws FileNotFoundException {

        boolean found = false;

        while (scan.hasNext()) {
            if (username.equals(scan.next()) || email.equals(scan.next())) {
                found = true;
                break;
            }
        }

        if (found == false) {
            users temp = new users(username, email, password);
            userStorage.append(temp.toString());
        }

        scan.close();
        userStorage.close();

    }

    public void signIn(String username, String password) {

        while (scan.hasNext()) {
            if (username.equals(scan.next())) {
                if (password.equals(scan.next())) {
                    continue;
                } else {
                    System.out.print("Invalid Username or Password");
                    return;
                }
            } else {
                System.out.print("Invalid Username or Password");
                return;
            }
        }

    }

}