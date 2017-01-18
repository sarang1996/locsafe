package punchtech.demo;

import java.util.List;

/**
 * Created by ASUS on 11-01-2017.
 */

public class group {

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public List<String> getMembers_name() {
        return members_name;
    }

    public void setMembers_name(List<String> members_name) {
        this.members_name = members_name;
    }

    public group(List<String> members_name, String g_name) {
        this.g_name = g_name;
        this.members_name = members_name;
    }

    String g_name;
    List<String> members_name;

    group() {

    }

}
