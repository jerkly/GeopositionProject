package example.ru.geoinn;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {
    private final static int PORT = 3000;
    private final static String IP_ADDRESS = "10.241.3.176";

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


        TextView wifiTv = (TextView) findViewById(R.id.map_btn);

        WifiManager wifiMan = (WifiManager) this.getSystemService(
                Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();
        String macAddr = wifiInf.getBSSID();

        wifiTv.setText(macAddr);


        String strEndPoint = "http://" + IP_ADDRESS + ":" + PORT;

        String sendMacAddr = macAddr.replaceAll(":", "");


        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(strEndPoint).build();
        RequestManager hotelResponseInterface = restAdapter.create(RequestManager.class);

        hotelResponseInterface.getRoom(sendMacAddr, new Callback<RespEntity>() {
            @Override
            public void success(RespEntity respEntity, Response response) {
                Log.d(MainActivity.class.getSimpleName(), "name: " + respEntity.getName());
                Log.d(MainActivity.class.getSimpleName(), "err: " + respEntity.getErr());
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


//        final FragmentManager fm = getSupportFragmentManager();
//        final Fragment[] fragment = new Fragment[1];

//        TextView mapBtn = (TextView) findViewById(R.id.map_btn);
//        mapBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                fragment[0] = fm.findFragmentById(R.id.map_container);
//                if (fragment[0] == null) {
//                    fragment[0] = new GroupMapFragment();
//                }
//                fm.beginTransaction().addToBackStack(null).replace(R.id.container, fragment[0]).commit();
//            }
//        });
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
