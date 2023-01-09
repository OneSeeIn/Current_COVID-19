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
public class PostDto {
    
    private Long id;  //게시글 고유번호
    private String title;   //제목
    private String contents;  //내용
    private String create_user_id;   //생성유저
    private String update_user_id;   //수정유저
    private Timestamp create_dt;  //생성일시
    private Timestamp update_dt;  //수정일시
    //Builder
    public PostDto(Long id, String title, String contents, String create_user_id, String update_user_id, Timestamp create_dt, Timestamp update_dt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.create_user_id = create_user_id;
        this.update_user_id = update_user_id;
        this.create_dt = create_dt;
        this.update_dt = update_dt;
    }
}
