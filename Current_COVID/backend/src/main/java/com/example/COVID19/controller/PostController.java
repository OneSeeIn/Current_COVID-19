package com.example.COVID19.controller;

import org.apache.logging.log4j.Logger;
import org.aspectj.apache.bcel.classfile.Module.Require;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.COVID19.model.PostRequest;
import com.example.COVID19.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Map;
@Api(tags = "게시물")
@RestController
@RequestMapping("post")
@Log4j2
public class PostController{

    @Autowired
    private PostService postService;

    @Operation(summary="게시물 업로드", description="게시물 업로드")
    @ApiResponse(code = 200, message="ok")
    @PostMapping("postImg")
    public Object postImg(
        @Parameter(description = "게시물 요청 오브젝트", required = true, example = "{ userId: \"jhsong\", postTitle: \"제목입니다\", postContent: \"내용입니다.\" }") 
        @RequestPart(value = "files") MultipartFile[] files,
        @RequestPart(value = "postRequest") PostRequest postRequest
        ) {
        log.info("postRequest: " + postRequest);
        return postService.postImg(postRequest,files);
    }
    @GetMapping("getImg")
    public String getImg(String url) {
        System.out.println("cloud");
        return postService.getImg(url);
    }

    @PostMapping("test")
    public Object test(MultipartFile file) throws Exception {
        System.out.println(file);
        return postService.test(file);
        // return null;
    }
    @PostMapping("test2")
    public Object test2(
        @RequestParam("userId") String userId, 
        @RequestParam("files") MultipartFile[] files
        ) throws Exception {
        System.out.println(userId);
        System.out.println(files[0].getSize());
        return null;
    }
    // @GetMapping("/saveFromApi")
    // public List saveFromApi() throws Exception{
    //     return postService.saveFromApi();
    // }

    // @GetMapping("get/listPage")
    // public Object getListPage(
    //         @RequestParam("index")int index,
    //         @RequestParam("size")int size,
    //         @RequestParam(value = "startCreateDt",required = false)String startCreateDt,
    //         @RequestParam(value ="endCreateDt",required = false)String endCreateDt
    // ) throws Exception{
    //     return postService.getListPage(index,size,startCreateDt,endCreateDt);
    // }


}