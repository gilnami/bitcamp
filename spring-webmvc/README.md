# 버전 별 주제

## src05 - 설정 클래스를 사용하여 프론트 컨트롤러 설정
- web.xml이 아닌 클래스를 통해 프론트 컨트롤러 설정
- 작업
  - web.xml에서 프론트 컨트롤러 지정하는 부분을 제거한다.

## src04 - 스프링 설정 파일의 경로 지정하기
- 기본 경로(/WEB-INF)가 아닌 다른 경로에 있는 설정파일 지정하기
- 작업
  - /WEB-INF/spring 폴더 생성 
  - 스프링 설정파일을 spring 폴더로 이동
  - web.xml에 설정 파일의 위치를 지정


## src03 - ContextLoaderListener 사용
- 프론트 컨트롤러들이 공유하는 객체는 ContextLoaderListener애서 관리한다.
- 작업
  - web.xml에 ContextLoaderListener등록
  - /WEB-INF/app-context.xml생성
  
## src02 - 멀티 프론트 컨트롤러 설정
- URL에 따라 여러 개의 프론트 컨트롤러를 설정
- 작업내용
- web.xml 변경
- - /WEB-INF/json-servlet.xml 생성
- 

## src01 - 프론트 컨트롤러 설정
- XML 기반으로 프론트 컨트롤러 설정하기
- 작업내용
  - web.xml 생성
  - DispatcherServlet 등록
  - /WEB-INF/dispatcher-servlet.xml 생성
  - /index.heml/ 생성
- 학습
  - DispatcherServlet은 프론트 컨트롤러 역할을 수행한다.
  - DispatcherServlet은 내부적으로 IoC 컨테이너를 보유하고 있다.
   그래서 IoC 컨테이너의 설정파일이 필요하다.
  - DispatcherServlet은 다음 규칙에 따라 만든 IoC 컨테이너의 설정파일을 자동으로 찾는다.
        /WEB-INF/[서블릿 별명]-servlet.xml
  - /index.html 생성
  - HelloController 생성