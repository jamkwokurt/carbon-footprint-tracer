package com.example.carbonfootprint;

import android.widget.ImageView;

public class User {
    String username, email;
    ImageView profile_pic;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ImageView getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(ImageView profile_pic) {
        this.profile_pic = profile_pic;
    }

    @Override
    public String toString() {
        return "com.example.carbonfootprint.User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", profile_pic=" + profile_pic +
                '}';
    }
}
