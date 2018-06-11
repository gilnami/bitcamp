// 트랜잭션(transaction) - auto commit
package step25.ex7;

import java.sql.DriverManager;

public class Exam01_2 {

    public static void main(String[] args) throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/java106db",
                "java106", "1111");
        
        // 커넥션을 사용하기 전에 auto commit을 false로 설정하라!
        con.setAutoCommit(false);
        // 이후부터 이 커넥션으로 실행하는 모든 SQL은 
        // commit을 요청하기 전에는 table에 그 결과를 적용하지 않는다.
        // commit을 요청하기 전에 수행한 데이터를 변경하는 모든 작업은(insert,update,delete)
        // DBMS의 임시 테이블에 보관된다.
        // 연결이 끊어지면 임시 테이블에 보관된 데이터는 버려진다.
        // 따라서 연결을 끊기 전에 테이블에 적용하고 싶다면,
        // 반드시 commit을 요청해야 한다.
        //
        
        java.sql.PreparedStatement stmt = con.prepareStatement(
                "insert into ex_board(bno,titl,cont,rdt) values(?,?,?,now())");
        
        stmt.setInt(1, 111);
        stmt.setString(2, "1111");
        stmt.setString(3, "xxxx");
        stmt.executeUpdate();
        System.out.println("입력성공");
        
        stmt.setInt(1, 112);
        stmt.setString(2, "1111");
        stmt.setString(3, "xxxx");
        stmt.executeUpdate();
        System.out.println("입력성공");
        
        // 만약 게시물 번호가 중복된다면 입력 실패할 것이다!
        // 다음 실행에서 입력을 실패한다 하더라도
        // 이전의 입력한 사항은 유효하다!
        // 왜? 각 insert, update, delete 마다 즉시 table에 적용되기 때문이다.
        stmt.setInt(1, 113);
        stmt.setString(2, "1111");
        stmt.setString(3, "xxxx");
        stmt.executeUpdate();
        System.out.println("입력성공");
        
        // 이렇게 commit을 해야만 DB의 연결을 끊기 전에
        // 임시 저장소에 보관된 변경작업결과(insert,update,delete)를
        // 실제 테이블에 적용한다.
        
        con.commit();
        
        stmt.close();
        con.close();
        System.out.println("입력완료");
    }
}







