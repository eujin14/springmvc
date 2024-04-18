package com.example.demo.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import com.example.demo.domain.Member;

class MemoryMemberRepositoryTest {
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	 public void afterEach() {
	 repository.clearStore();
	 }
	
	 @Test
	 public void save() {
	 //given
	 Member member = new Member();
	 member.setName("spring");
	 
	 //when
	 repository.seve(member);
	
	 //then
	 Member result = repository.findById(member.getId()).get();
	 assertThat(result).isEqualTo(member);
	 }
	 
	 
	 @Test
	 public void findByName() {
	 //given
	 Member member1 = new Member();
	 member1.setName("spring1");
	 repository.seve(member1);
	 
	 Member member2 = new Member(); 
	 member2.setName("spring2");
	 repository.seve(member2);
	 
	 //when
	 Member result = repository.findByName("spring1").get();
	 
	 //then
	 assertThat(result).isEqualTo(member1);
	 }
	 
	 
	 
	 
	 @Test
	 public void findAll() {
	 //given
	 Member member1 = new Member();
	 member1.setName("spring1");
	 repository.seve(member1);
	 
	 Member member2 = new Member();
	 member2.setName("spring2");
	 repository.seve(member2);
	 //when
	 List<Member> result = repository.findAll();
	 //then
	 assertThat(result.size()).isEqualTo(2);
	 }
	}