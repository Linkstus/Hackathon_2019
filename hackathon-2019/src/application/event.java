package application;

import java.util.ArrayList;
import java.util.Random;

public class event {

    String name;
    String date;
    String desc;
    users host;
    ArrayList<String> attendees = new ArrayList<String>();
    String token;

    public event(String name, String date, users host, String desc) {
        this.name = name;
        this.date = date;
        this.host = host;
        this.desc = desc;
    }

    public void makeToken() {
        Random rand = new Random(100000000);
        token = String.valueOf(rand);
    }

    public String getToken() {
        return token;
    }
    
    public String toString() {
    	return name + "\n" + host.getUsername() + "\n" + date + "\n" + desc;
    }
}