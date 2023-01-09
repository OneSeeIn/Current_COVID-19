package com.example.COVID19.repository;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "tb_post")
@Data
@ToString
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;  // 게시글 고유번호
    @Column(name = "title")
    private String title;   // 제목
    @Column(name = "contents")
    private String contents;  // 내용
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "create_user")
    @JsonBackReference
    private Member createUser;   // 생성유저
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "update_user")
    private Member updateUser;   // 수정유저 
    @CreationTimestamp 
    @Column(name = "create_dt")
    private Timestamp createDt;  // 생성일시 
    @UpdateTimestamp 
    @Column(name = "update_dt")
    private Timestamp updateDt;  // 수정일시

    @OneToMany(mappedBy = "postId",fetch = FetchType.LAZY)
    private List<PostResource> postResourcesList = new ArrayList<>();

    //make post builder

    @Builder
    public Post(Long id,String title, String contents,Timestamp create_dt, Timestamp update_dt,Member create_user,Member update_user) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.createDt = create_dt;
        this.updateDt = update_dt;
        this.createUser = create_user;
        this.updateUser = update_user;
    }

}

