// 상수 코드를 스태틱 중첩 클래스로 다루기
package step17.ex2;

public class Exam03 {
    public static void main(String[] args) {
        Product2 p = new Product2();
        p.category = Category2.appliance.TV;
        p.name = "울트라비전 뷰";
        p.price = 2000000;
    }
}
