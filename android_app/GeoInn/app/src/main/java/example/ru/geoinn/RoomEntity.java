package example.ru.geoinn;

/**
 * dimashilin
 * 21.07.15.
 * Inno Geoposition Service
 */
public class RoomEntity {
    private String name;
    private String err;

    public RoomEntity(String name, String err) {
        this.name = name;
        this.err = err;
    }

    public String getName() {
        return name;
    }

    public String getErr() {
        return err;
    }
}
