import java.util.UUID;

/**
 * Created by tvv89 on 08.02.2017 for JavaLabs.
 */
public class TrackParameters {
    private UUID Id;
    private Integer distance;
    private Integer time;
    private double startLat;
    private double startLon;
    private double endLat;
    private double endLon;
    private String Origin;
    private String Destination;


    public TrackParameters(Integer distance, Integer time) {

        this.distance = distance;
        this.time = time;
    }

    public TrackParameters(Integer distance, Integer time, String origin, String destination) {
        this.Id = UUID.randomUUID();
        this.distance = distance;
        this.time = time;
        Origin = origin;
        Destination = destination;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public long getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public double getStartLat() {
        return startLat;
    }

    public void setStartLat(double startLat) {
        this.startLat = startLat;
    }

    public double getStartLon() {
        return startLon;
    }

    public void setStartLon(double startLon) {
        this.startLon = startLon;
    }

    public double getEndLat() {
        return endLat;
    }

    public void setEndLat(double endLat) {
        this.endLat = endLat;
    }

    public double getEndLon() {
        return endLon;
    }

    public void setEndLon(double endLon) {
        this.endLon = endLon;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }
}
