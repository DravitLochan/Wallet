package naman.com.wallet;

/**
 * Created by naman_3uwwmg4 on 12-10-2016.
 */
public class UserEntry {
    public String reason;
    public String day;
    public float amt;

    public UserEntry(String reason, String day, float amt)
    {
        this.reason= reason;
        this.day= day;
        this.amt= amt;
    }
}
