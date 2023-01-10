package com.example.COVID19.service;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.COVID19.model.PostRequest;
import com.example.COVID19.repository.Member;
import com.example.COVID19.repository.MemberRepository;
import com.example.COVID19.repository.Post;
import com.example.COVID19.repository.PostRepository;
import com.example.COVID19.repository.PostResource;
import com.example.COVID19.repository.PostResourceRepository;

@Service
public class PostService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostResourceRepository postResourceRepository;

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
  "cloud_name", "osicloud",
  "api_key", "891135832656525",
  "api_secret", "_p6uX3GMHktl41FFfqr9ZfHel0o"));

    // private static String CLOUDINARY_URL = "http://cloudinary://my_key:my_secret@my_cloud_name?cname=mydomain.com&upload_prefix=myprefix.com";

    // @Transactional
    public Object postImg(PostRequest postRequest, MultipartFile[] files) {
        try{
        System.out.println("############### Post 저장 시작#############");
        
        Member user = memberRepository.findById(postRequest.getUserId()).orElseThrow(() ->  new Exception());
        Post post = Post.builder()
        .create_user(user)
        .title(postRequest.getPostTitle())
        .contents(postRequest.getPostContent())
        .build();
        Post result  = postRepository.save(post);
        ArrayList<PostResource> resourceList = new ArrayList<>();
        for(MultipartFile file : files){
            Map upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", file.getOriginalFilename()));
        
            PostResource postResource =  PostResource.builder().
                                resourceUrl((String)upload.get("url"))
                                .createUser(postRequest.getUserId())
                                .postId(post)
                                .build();
            resourceList.add(postResourceRepository.save(postResource));
        }
        System.out.println("######## Post 저장 완료###########");
        result.setPostResourcesList(resourceList);
        return result;
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage() + " " + e.getCause();
        }
    }
    // make getImg
    public String getImg(String url) {
        try{
        return "";
        }   catch(Exception e){
            e.printStackTrace();
            return e.getMessage() + " " + e.getCause();            
        }
    }


    public Object test(MultipartFile file) {
        
        try{
        System.out.println("파일읽음");
        System.out.println(cloudinary.getUserAgent());
        Map upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("public_id", file.getName()));
        return upload;
        }catch(Exception e){
        e.printStackTrace();
        return e.getMessage() + " " + e.getCause();            
        }
    }
}


