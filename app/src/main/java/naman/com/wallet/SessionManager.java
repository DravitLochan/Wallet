package naman.com.wallet;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by naman_3uwwmg4 on 02-10-2016.
 */

public class SessionManager {

    Context context;
    public SessionManager(Context context)
    {
        this.context=context;
    }



    public boolean loggedIn()
    {
        if(getPreferences("status").equals("true"))
            return true;
        else
            return false;
    }

    public void logout()
    {
        setPreferences("status","false");
        setPreferences("email","");
        setPreferences("name","");
    }


    public void createSession(String email, String name)
    {
        setPreferences("status","true");
        setPreferences("email",email);
        setPreferences("name",name);
    }



    public void setPreferences(String key, String value) {

        SharedPreferences.Editor editor = context.getSharedPreferences("Wallet",Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();

    }
    public String getPreferences(String key) {

        SharedPreferences prefs = context.getSharedPreferences("Wallet",Context.MODE_PRIVATE);
        String position = prefs.getString(key,"false");
        return position;
    }
}
