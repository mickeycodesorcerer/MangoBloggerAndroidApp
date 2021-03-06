package com.mangobloggerandroid.app.Login;

/**
 * Created by ujjawal on 3/11/17.
 *
 */

public class User {
    private String id;
    private String username;
    private String nicename;
    private String email;
    private String displayname;
    private String description;
    private String cookie;
    private boolean isLoggedIn;

    public User(String id, String username,  String email,String displayname) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.displayname = displayname;
        this.description = description;
    }

    public User(String id, String username,  String email,
                 String displayname, boolean isLoggedIn, String cookie) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.displayname = displayname;
        this.cookie = cookie;
        this.isLoggedIn = isLoggedIn;
    }


    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getCookie() {
        return cookie;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplayname() {
        return displayname;
    }

    public String getId() {
        return id;
    }

    public String getNicename() {
        return nicename;
    }

}
