import java.util.*;
import java.io.*;

public class Hackathon {

    File userFile = new File("C:/Users/socce/Desktop/hackathon 2019/temp/users.txt");
    PrintWriter userStorage = null;
    Scanner scan = null;

    public void createUser(String username, String email, String password) {

        try {
            userStorage = new PrintWriter(userFile);
            scan = new Scanner(userFile);
        } catch (Exception e) {
            System.out.println("File failed");
        }
        boolean found = false;

        while (scan.hasNext()) {
            if (username.equals(scan.next()) || email.equals(scan.next())) {
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