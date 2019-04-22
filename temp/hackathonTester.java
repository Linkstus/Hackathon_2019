import java.io.FileNotFoundException;

public class hackathonTester {

    public static void main(String[] args) {
        Hackathon hack2 = new Hackathon();
        try {
            hack2.createUser("Carson", "carsodavis@vsu", "password123");
            hack2.createUser("Carson", "carsodavis@vsu", "password123");
            hack2.createUser("Dylan", "dylansmith@vsu", "wordPass1");
        } catch (Exception e) {
            System.out.print("This is fine");
        }
    }

}