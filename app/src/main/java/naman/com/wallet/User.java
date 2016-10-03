package naman.com.wallet;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class User extends AppCompatActivity  {
    TextView email,name;
    Button logout;
    SessionManager manager;
    Context context;
    DrawerLayout drawerLayout;
    //ActionBarDrawerToggle mDrawerToggle;
    String[] contents;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        context=this;
        initUI();

    }

    private void initUI() {
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
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        contents= getResources().getStringArray(R.array.contents);
        mListView=(ListView) findViewById(R.id.left_drawer);
        mListView.setAdapter(new ArrayAdapter<String>(context,R.layout.drawer_list_item,contents));
        mListView.setOnItemClickListener(new DrawerItemClickListener());

        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}
