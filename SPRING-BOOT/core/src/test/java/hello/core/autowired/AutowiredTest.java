package hello.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Member;
import io.micrometer.common.lang.Nullable;

class AutowiredTest {

	@Test
	void AutowiredOption() {
		new AnnotationConfigApplicationContext(TestBean.class);
	}
 static class TestBean{
	 @Autowired(required = false)
	 public void setNoBean1(Member noBean1) {
		 System.out.print("noBean1 =" + noBean1);
	 }
	 
	 @Autowired
	 public void setNoBean2(@Nullable Member noBean2) {
		 System.out.println(" noBean2= "+ noBean2);
	 }
	 
	 @Autowired
	 public void setNoBean3(Optional<Member> noBean3) {
		 System.out.print("noBean3"+ noBean3);
	 }
 }
}
