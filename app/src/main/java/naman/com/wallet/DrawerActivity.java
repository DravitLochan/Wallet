package naman.com.wallet;

import android.support.annotation.Nullable;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static naman.com.wallet.R.array.contents;

public class DrawerActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    String[] content;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        content= getResources().getStringArray(R.array.contents);
        mListView=(ListView) findViewById(R.id.left_drawer);
        mListView.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item,R.id.text1,content));

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
        defaultFragment();
    }

    private void defaultFragment() {
        Fragment fragment = new User();
        FragmentManager fm = getFragmentManager();
        //TODO: try this with add
        fm.beginTransaction().replace(R.id.content_frame,fragment).commit();
    }

    private class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            selectItem(i);
        }

        private void selectItem(int i) {
            Fragment fragment = null;
            switch(i)
            {
                case 0:
                    fragment=new User();
                    break;
                case 1:
                    //fix here for null ptr exception
                    break;
                case 2:
                    break;

            }
            FragmentManager fm = getFragmentManager();
            //TODO: try this with add
            fm.beginTransaction().replace(R.id.content_frame,fragment).commit();
            drawerLayout.closeDrawer(mListView);
        }
    }
}
