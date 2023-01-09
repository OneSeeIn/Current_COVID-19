package com.example.COVID19.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@ToString
@NoArgsConstructor
public class PostResourceDto {
    
    private Long id;  // 리소스 고유번호
    private String create_user_id;  //생성유저  
    private Timestamp create_dt;  //생성일시
    private String resource_url;  //리소스 URL
    private long post_id;   //관련 게시물 번호

    //Builder
    public PostResourceDto(Long id, String create_user_id, Timestamp create_dt, String resource_url, long post_id) {
        this.id = id;
        this.create_user_id = create_user_id;
        this.create_dt = create_dt;
        this.resource_url = resource_url;
        this.post_id = post_id;
    }
}
