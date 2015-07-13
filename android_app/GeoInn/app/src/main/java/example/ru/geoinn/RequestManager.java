package example.ru.geoinn;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by dimashilin on 13.07.15.
 */
public interface RequestManager {
    @GET("/u/109052005/1/0777.json")
    void getHostels(
            Callback<ArrayList<Hotel>> callback
    );

    @GET("/u/109052005/1/{id}.json")
    void getHostelsDetail(@Path("id") int id, Callback<Hotel> hostelCallback);


}
