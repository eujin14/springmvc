package hello.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

class MemberServiceTest {
	/*
	 * AppConfig appConfig = new AppConfig(); 
	 * MemberService memberService = appConfig.memberService();
	 */
	MemberService memberService;
	
	@BeforeEach
	 public void beforeEach() {
	 AppConfig appConfig = new AppConfig();
	 memberService = appConfig.memberService();
	 }
 
 @Test
 void join() {
 //given
	 
 Member member = new Member(1L, "memberA", Grade.VIP); //when
 memberService.join(member);
 
 Member findMember = memberService.findMember(1L);
 //then
 
 Assertions.assertThat(member).isEqualTo(findMember);
 }
}
