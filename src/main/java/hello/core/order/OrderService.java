package hello.core.order;

public interface OrderService {
    // public은 외부에 공개하는 것이라서 파일명과 인터페이스명 또는 클래스 명이 일치해야한다

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
