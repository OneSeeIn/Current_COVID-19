package com.example.oneseein.controller;

import com.example.oneseein.model.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@RequestMapping("/member")
@RestController
public class MemberController {

    @GetMapping("/test")
    public Member memberTest(){
        return new Member(0L, "권민서", 28, "백운동", new Date());
    }
    @GetMapping("/test2")
    public ArrayList<Member> memberTest2(){
        return new ArrayList(Arrays.asList(
                new Member(1L, "권민서", 28, "광화문", new Date()),
                new Member(2L, "송지훈", 27, "방배", new Date()),
                new Member(3L, "구희정", 28, "재택", new Date()),
                new Member(4L, "최완우", 28, "충주", new Date()),
                new Member(5L, "박상민", 28, "제천", new Date())
        ));
    }


}
