package naman.com.wallet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class User extends AppCompatActivity {
    TextView email,name;
    Button logout;
    SessionManager manager;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        context=this;
        manager= new SessionManager(context);
        email=(TextView)findViewById(R.id.emailid);
        name=(TextView)findViewById(R.id.name);
        email.setText(manager.getPreferences("email"));
        name.setText(manager.getPreferences("name"));
        logout=(Button)findViewById(R.id.button_logout) ;
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.logout();
            }
        });
    }
}
