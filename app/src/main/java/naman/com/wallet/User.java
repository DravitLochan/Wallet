package naman.com.wallet;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;

public class User extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.activity_user,container,false);
        context=super.getActivity();
        initUI(root);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.setTitle("Money Manager");
        series.setColor(Color.GREEN);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);
        graph.addSeries(series);

        return root;
    }

    TextView email,name;
    Button logout;
    SessionManager manager;
    Context context;
    GraphView graph;
    ListView lvActivity;
    ArrayList<UserEntry> arrayUserEntry;


    private void initUI(View root) {
        graph = (GraphView) root.findViewById(R.id.graph);
        manager= new SessionManager(context);
        lvActivity = (ListView) root.findViewById(R.id.listview_activity);
         arrayUserEntry = new ArrayList<>();
        EntryUserAdapter adapter = new EntryUserAdapter(context,arrayUserEntry);
        lvActivity.setAdapter(adapter);
        populateData();
        /*logout=(Button)root.findViewById(R.id.button_logout) ;
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.logout();
            }
        });*/


    }

    private void populateData() {
        UserEntry entry1= new UserEntry("Burger","Thu",-50);
        UserEntry entry2= new UserEntry("Pizza","Thu",-250);
        UserEntry entry3= new UserEntry("Salary","Thu",5000);
        UserEntry entry4= new UserEntry("Paypal","Thu",1700);
        arrayUserEntry.add(entry1);
        arrayUserEntry.add(entry3);
        arrayUserEntry.add(entry2);
        arrayUserEntry.add(entry4);
    }
}
