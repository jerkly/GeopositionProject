package example.ru.geoinn;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        String[] groupName = getResources().getStringArray(R.array.spinner_list);
        Spinner groupSpinner = (Spinner) findViewById(R.id.spinner_group_list);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, R.layout.my_spinner_textview, groupName);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        groupSpinner.setAdapter(spinnerAdapter);
        groupSpinner.setPrompt("Group List");


        final FragmentManager fm = getSupportFragmentManager();
        final Fragment[] fragment = new Fragment[1];

        TextView mapBtn = (TextView) findViewById(R.id.map_btn);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment[0] = fm.findFragmentById(R.id.map_container);
                if (fragment[0] == null) {
                    fragment[0] = new GroupMapFragment();
                }
                fm.beginTransaction().addToBackStack(null).replace(R.id.container, fragment[0]).commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
