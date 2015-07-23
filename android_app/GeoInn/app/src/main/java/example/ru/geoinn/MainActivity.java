package example.ru.geoinn;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {
    private final static int PORT = 3000;
    private final static String IP_ADDRESS = "10.241.2.100";
    private RoomEntity roomEntity;
    private TextView findLockBtn;
    private TextView textLocation;
    private ImageView mapImage;
    private String strEndPoint;
    private String sendMacAddr;


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

        findLockBtn = (TextView) findViewById(R.id.find_lock_btn);


        mapImage = (ImageView) findViewById(R.id.map_image);
        textLocation = (TextView) findViewById(R.id.tv_location);

        WifiManager wifiMan = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();
        String macAddr = wifiInf.getBSSID();

        Log.d(MainActivity.class.getSimpleName(), "Mac" + " " + macAddr);

        strEndPoint = "http://" + IP_ADDRESS + ":" + PORT;
        sendMacAddr = macAddr.replaceAll(":", "");


        findLockBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(strEndPoint).build();
                RequestManager hotelResponseInterface = restAdapter.create(RequestManager.class);
                hotelResponseInterface.getRoom(sendMacAddr, new Callback<RoomEntity>() {
                    @Override
                    public void success(RoomEntity entity, Response response) {
                        roomEntity = entity;
                        Log.d(MainActivity.class.getSimpleName(), "name: " + entity.getName());
                        Log.d(MainActivity.class.getSimpleName(), "err: " + entity.getErr());

                        if (roomEntity.getName().equals("") || roomEntity == null) {
                            textLocation.setText("Sorry, we can't determine your position");

                        } else {
                            textLocation.setText(roomEntity.getName());
                            mapImage.setImageDrawable(getResources().getDrawable(R.drawable.library_2_floor));
                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        textLocation.setText("Sorry, we can't determine your position");
                    }
                });
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
