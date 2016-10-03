package naman.com.wallet;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by naman_3uwwmg4 on 04-10-2016.
 */
public class DrawerItemClickListener implements android.widget.AdapterView.OnItemClickListener {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        selectItem(pos);
        Snackbar.make(view,pos,Snackbar.LENGTH_SHORT).show();
    }

    private void selectItem(int pos) {


    }
}
