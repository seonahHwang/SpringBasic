package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRespository{
    private static Map<Long,Member> store = new HashMap<>(); //동시성 이슈를 고려하면 concurrentmap을 사용하는게 맞음. 지금이건 단순 예제


    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
