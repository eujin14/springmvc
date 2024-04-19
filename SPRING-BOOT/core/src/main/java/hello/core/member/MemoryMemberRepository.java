package hello.core.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository {
	
	private static Map<Long, Member> store = new HashMap<>();//저장공간

	@Override
	public void save(Member member) {
		store.put(member.getId(), member);//지정된 id로 해당 member를 넣고

	}

	@Override
	public Member findById(Long memberId) {
		
		return store.get(memberId);//null도 반환될 수 있게 감싸주고 반환
	}

}
