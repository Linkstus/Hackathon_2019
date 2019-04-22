public class users {

    String username;
    String email;
    String password;
    double averageRating;
    double numberOfRatings;

    public users(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUserName) {
        this.username = newUserName;
    }

    public String getEmail() {
        return email;
    }

    public void setNewEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void addNewRating(int newRating) {
        averageRating = (averageRating + numberOfRatings + newRating) / (numberOfRatings + 1);
        numberOfRatings++;
    }

    // Change to %.1 float
    public double getRating() {
        return averageRating;
    }

    public String toString() {
        String msg = username + " " + email + " " + password;
        return msg;
    }

}