package naman.com.wallet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button LoginButton;
    final String tag="Wallet";
    Context context;
    SessionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        manager = new SessionManager(context);
        if(!manager.loggedIn())
        Init();
        else
        pass();
    }

    private void pass() {
        Intent intent = new Intent(this,User.class);
        startActivity(intent);
        finish();
    }

    private void Init() {

        final Handler handle = new Handler();
        LoginButton= (Button) findViewById(R.id.loginButton);
        final ProgressDialog pd= new ProgressDialog(context);


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.setTitle("Logging in");
                pd.setMessage("Please wait while we authenticate");
                pd.show();
                handle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pd.dismiss();
                        manager.createSession("abc@def.com","test");
                        pass();
                    }
                },5000);
            }
        });
    }
}
