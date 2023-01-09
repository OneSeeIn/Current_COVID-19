package com.example.COVID19.service;
import java.io.File;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import com.example.COVID19.repository.Member;
import com.example.COVID19.repository.MemberRepository;
import com.example.COVID19.repository.Post;
import com.example.COVID19.repository.PostRepository;
import com.example.COVID19.repository.PostResource;
import com.example.COVID19.repository.PostResourceRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Object login(Member member) {
        return memberRepository.findByIdAndPwd(member.getId(),member.getPwd()).orElse(null);
    }

    
}
