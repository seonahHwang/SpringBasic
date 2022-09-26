package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRespository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRespository memberRespository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRespository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        /*설계가 잘된 부분
        할인에 대해서 orderservice가 관여하는게 없고, 할인은 다 discountPolicy가 담당
        단일책임원칙이 지켜진 부분
        */

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
