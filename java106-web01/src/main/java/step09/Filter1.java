// 웹 애플리케이션 컴포넌트 : 필터
package step09;

// 웹 애플리케이션 컴포넌트?
// - 서블릿(Servlet) : 클라이언트의 요청을 처리하는 역할
// - 필터(Filter) : 서블릿을 실행하기 전/후에 보조 작업을 수행
// - 리스너(Listener) : 서블릿 컨테이너에서 특정 사건이 발생할 때 작업을 수행
//
// 필터
// - 서블릿을 실행하기 전이나 후에 특정 작업을 수행하고 싶을 때 사용하는 기술이다.
// - 예:
// => 클라이언트의 접속을 기록하는 기능
// => 클라이언트가 보낸 데이터의 압축을 해제
// => 클라이언트가 보낸 데이터의 암호를 해제
// => 서블릿의 작업을 수행하기 전에 공통으로 처리해야 하는 작업을 수행
// => 클라이언트의 인증 또는 권한 검사
//
public class Filter1 {

}
