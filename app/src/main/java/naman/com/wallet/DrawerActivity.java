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
        Fragment fragment = new FragmentGenerator();
        Bundle bundle= new Bundle();
        bundle.putInt(FragmentGenerator.position,1);
        fragment.setArguments(bundle);

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
            Fragment fragment = new FragmentGenerator();
            Bundle bundle= new Bundle();
            bundle.putInt(FragmentGenerator.position,i);
            fragment.setArguments(bundle);

            FragmentManager fm = getFragmentManager();
            //TODO: try this with add
            fm.beginTransaction().replace(R.id.content_frame,fragment).commit();

            drawerLayout.closeDrawer(mListView);
        }
    }

    public static class FragmentGenerator extends Fragment {
        public static String position="position";
        public FragmentGenerator() {
            super();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            int activity=0;
            int i=getArguments().getInt(position);
            switch(i)
            {
                case 1:
                    activity=R.layout.activity_user;
                break;
                default:
                    activity=R.layout.activity_user;
            }
            View fragment = inflater.inflate(activity,container,false);
            return fragment;
        }
    }
}
