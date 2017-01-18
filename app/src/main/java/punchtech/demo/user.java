package punchtech.demo;

/**
 * Created by ASUS on 11-01-2017.
 */

public class user {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    String email;
    String id;
    String lat;

    public String getLong1() {
        return long1;
    }

    public void setLong1(String long1) {
        this.long1 = long1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String long1;

    public user(String email, String id, String lat, String long1, String name) {
        this.email = email;
        this.id = id;
        this.lat = lat;
        this.long1 = long1;
        this.name = name;
    }

    String name;

    public user() {
    }
}
