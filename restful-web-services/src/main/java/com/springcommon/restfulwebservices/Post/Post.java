package com.springcommon.restfulwebservices.Post;

import com.springcommon.restfulwebservices.users.User;

import java.time.LocalDate;

public class Post {
    private String post;
    private LocalDate timeStamp;
    private User user;

    public Post(String post,User user, LocalDate timeStamp){
       super();
       this.post = post;
       this.user = user;
       this.timeStamp = timeStamp;
    }
    public String getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post='" + post + '\'' +
                ", timeStamp=" + timeStamp +
                ", user=" + user +
                '}';
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }
}
