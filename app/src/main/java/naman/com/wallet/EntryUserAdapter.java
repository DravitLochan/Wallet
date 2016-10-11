package naman.com.wallet;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by naman_3uwwmg4 on 12-10-2016.
 */
public class EntryUserAdapter extends ArrayAdapter<UserEntry> {

    public EntryUserAdapter(Context context,ArrayList<UserEntry> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        UserEntry user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_entry_row, parent, false);
        }
        // Lookup view for data population
        TextView reason = (TextView) convertView.findViewById(R.id.reason);
        TextView day = (TextView) convertView.findViewById(R.id.day);
        TextView amt = (TextView) convertView.findViewById(R.id.amt);
        // Populate the data into the template view using the data object
        reason.setText(user.reason);
        day.setText(user.day);
        if(user.amt < 0)
        {
            amt.setTextColor(Color.RED);
        }
        else
        {
            amt.setTextColor(Color.GREEN);
        }
        amt.setText(String.valueOf(user.amt));
        // Return the completed view to render on screen
        return convertView;

    }
}
