package google.service.entity;

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
    private String Origin_coord;
    private String Destination_coord;


    public TrackParameters(Integer distance, Integer time) {
        this.Id = UUID.randomUUID();
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

    public TrackParameters(Integer distance, Integer time, String origin, String destination, String origin_coord, String destination_coord) {
        this.Id = UUID.randomUUID();
        this.distance = distance;
        this.time = time;
        this.Origin = origin;
        this.Destination = destination;
        this.Origin_coord = origin_coord;
        this.Destination_coord = destination_coord;
    }

    @Override
    public String toString() {
        return this.getOrigin()+"----->"+this.getDestination();
    }

    public String getOrigin_coord() {
        return Origin_coord;
    }

    public void setOrigin_coord(String origin_coord) {
        Origin_coord = origin_coord;
    }

    public String getDestination_coord() {
        return Destination_coord;
    }

    public void setDestination_coord(String destination_coord) {
        Destination_coord = destination_coord;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public Integer getDistance() {
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
