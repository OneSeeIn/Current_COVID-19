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

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Timestamp;

@Entity(name = "tb_post_resources")
@Data
@ToString
@NoArgsConstructor
// @SequenceGenerator(name = "post_resources_seq", sequenceName = "post_resources_seq", initialValue=1)

public class PostResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;  // 리소스 고유번호
    @Column(name = "create_user")
    private String createUser;  //생성유저   
    @CreationTimestamp 
    @Column(name = "create_dt")
    private Timestamp createDt;  //생성일시
    @Column(name = "resource_url")
    private String resourceUrl;  //리소스 URL

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post postId;   //관련 게시물 번호



    //make postResource Builder

    @Builder
    public PostResource(Long id, String createUser, Timestamp createDt, String resourceUrl, Post postId) {
        this.id = id;
        this.createUser = createUser;
        this.createDt = createDt;
        this.resourceUrl = resourceUrl;
        this.postId = postId;
    }
}

