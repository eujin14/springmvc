package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	
	private final MemberService memberService;
	 
	/*
	 * @Autowired public void setMemberService(MemberService memberService) {
	 * this.memberService = memberService; }
	 */
	
	 @Autowired public MemberController(MemberService memberService) {
	 this.memberService = memberService; }
	 
	}
