public class event {

    String name;
    String date;
    String desc;
    users host;
    ArrayList<String> attendees = new ArrayList<String>();

    public event(String name, String date, users host, String desc) {
        this.name = name;
        this.date = date;
        this.host = host;
        this.desc = desc;
    }

}