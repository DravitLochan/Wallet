package naman.com.wallet;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class User extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.activity_user,container,false);
        context=super.getActivity();
        initUI(root);

        return root;
    }

    TextView email,name;
    Button logout;
    SessionManager manager;
    Context context;


    private void initUI(View root) {
        manager= new SessionManager(context);
        email=(TextView)root.findViewById(R.id.emailid);
        name=(TextView)root.findViewById(R.id.name);
        email.setText(manager.getPreferences("email"));
        name.setText(manager.getPreferences("name"));
        logout=(Button)root.findViewById(R.id.button_logout) ;
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.logout();
            }
        });

    }
}
