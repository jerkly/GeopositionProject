package example.ru.geoinn;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by dimashilin on 13.07.15.
 */
public interface RequestManager {

    @GET("/api/room/{mac}")
    void getRoom(@Path("mac") String macAddress, Callback<RoomEntity> callback);
}
