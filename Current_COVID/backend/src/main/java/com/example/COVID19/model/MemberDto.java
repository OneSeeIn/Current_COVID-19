package com.example.COVID19.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
public class MemberDto {
    private String id;  //게시글 고유번호
    private String name;   //이름
    private String email;  //이메일
    private String pwd;  //비밀번호
    private String create_user_id;  //생성유저
    private String update_user_id;  //수정유저
    private Timestamp create_dt;  //생성일시
    private Timestamp update_dt;  //수정일시

    //Builder
    public MemberDto(String id, String name, String email, String pwd, String create_user_id, String update_user_id, Timestamp create_dt, Timestamp update_dt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.create_user_id = create_user_id;
        this.update_user_id = update_user_id;
        this.create_dt = create_dt;
        this.update_dt = update_dt;
    }
}
