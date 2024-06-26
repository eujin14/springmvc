package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
			
			private final DiscountPolicy discountPolicy;
	        private final MemberRepository memberRepository;
	        
			/*
			 * @Autowired private DiscountPolicy rateDiscountPolicy;
			 */
	        
	        @Autowired
	        public OrderServiceImpl(
	        		MemberRepository memberRepository, 
	        		@MainDiscountPolicy DiscountPolicy discountPolicy) {
	        this.memberRepository = memberRepository;
	        this.discountPolicy = discountPolicy;
;
	        }
	        
			/*
			 * @Autowired public void setMemberRepository(MemberRepository memberRepository)
			 * { this.memberRepository = memberRepository; }
			 * 
			 * @Autowired public void setDiscountPolicy(DiscountPolicy discountPolicy) {
			 * this.discountPolicy = discountPolicy; }
			 */
	         
			

			
			// 할인은 내 책임이 아님! 할인에 관한건 전부 dicountPolicy에 넘김 (회원 등급, 상품 가격)
	        // SRP(단일 책임 원칙) 잘 지켜짐
			 @Override
			 public Order createOrder(Long memberId, String itemName, int itemPrice) {
			 Member member = memberRepository.findById(memberId);
			 int discountPrice = discountPolicy.discount(member, itemPrice);
			 return new Order(memberId, itemName, itemPrice, discountPrice);
			 }
			 
			 //테스트 용도
			 public MemberRepository getMemberRepository() {
				 return memberRepository;
			 }
			}


