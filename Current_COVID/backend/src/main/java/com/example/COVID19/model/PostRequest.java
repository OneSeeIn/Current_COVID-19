package com.example.COVID19.model;

import lombok.Data;

@Data
public class PostRequest {
    private String userId;
    private String postTitle;
    private String postContent;

}
