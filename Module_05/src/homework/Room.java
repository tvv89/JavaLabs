package homework;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Volodymyr Tymchuk on 26.11.2016 for JavaLabs.
 */

/*********************
 ******* task #1 ******
 **********************/


public class Room {
    private long id;
    private int price;
    private int persons;
    private Date dateAvailableFrom;
    private String hotelName;
    private String cityName;

    public Room(long id, int price, int persons, Date dateAvailableFrom, String hotelName, String cityName) {
        this.id = id;
        this.price = price;
        this.persons = persons;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotelName = hotelName;
        this.cityName = cityName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /*********************
     ******* task #2 ******
     **********************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return price == room.price &&
                persons == room.persons &&
                cityName == room.cityName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, persons, cityName);
    }

    //только для удобства отображение (этого нет в задании!!)
    @Override
    public String toString() {
        return (this != null) ? "Room{" +
                "id=" + id +
                ", price=" + price +
                ", persons=" + persons +
                ", dateAvailableFrom=" + dateAvailableFrom.toString() +
                ", hotelName='" + hotelName.toString() + '\'' +
                ", cityName='" + cityName.toString() + '\'' +
                '}': "null";

    }
}
