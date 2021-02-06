package info.adrian.a438restapi;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String userId;

    private int id;

    private String title;

    @SerializedName("body")
    private String text;

    public String getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
