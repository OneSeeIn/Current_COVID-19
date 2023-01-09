package com.example.COVID19.repository;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_member")
@Data
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "id")
    private String id;  //게시글 고유번호
    @Column(name = "name")
    private String name;   //이름
    @Column(name = "email")
    private String email;  //이메일
    @Column(name = "pwd")
    private String pwd;  //비밀번호
    @Column(name = "create_user")
    private String createUser;  //생성유저
    @Column(name = "update_user")
    private String updateUser;  //수정유저 
    @CreationTimestamp 
    @Column(name = "create_dt")
    private Timestamp createDt;  //생성일시 
    @UpdateTimestamp 
    @Column(name = "update_dt")
    private Timestamp updateDt;  //수정일시
    
    // @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    // private List<PostResource> postResourcesList = new ArrayList<>();
    @OneToMany(mappedBy = "createUser",fetch = FetchType.LAZY)
    private List<Post> postList1 = new ArrayList<>();
    @OneToMany(mappedBy = "updateUser",fetch = FetchType.LAZY)
    private List<Post> postList2 = new ArrayList<>();

    
    //make member Builder
    @Builder
    public Member(String id, String name, String email, String pwd, String createUser, String updateUser) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.createUser = createUser;
        this.updateUser = updateUser;
    }
}