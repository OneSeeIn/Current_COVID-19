package com.example.COVID19.controller;

import com.example.COVID19.repository.Member;
import com.example.COVID19.service.MemberService;
import com.example.COVID19.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/login")
    public Object login(@RequestBody Member member) {
        Member loggedinMember = (Member) memberService.login(member);
        // if(loggedinMember!=null){
        //     loggedinMember.setPwd(null);
        //     return loggedinMember;
        // }else{
        //     return "존재하지 않는 회원";
        // }
        return loggedinMember!=null;
    }



}