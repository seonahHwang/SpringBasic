package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRespository memberRespository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRespository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRespository.findById(memberId);
    }
}
