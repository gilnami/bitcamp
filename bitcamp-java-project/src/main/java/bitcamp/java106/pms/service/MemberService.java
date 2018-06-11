package bitcamp.java106.pms.service;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.domain.Member;

public interface MemberService {
    int delete(String id);
    List<Member> selectList(Map<String,Object> params);
    Classroom selectOne(int no);
    int insert(Member member);
    int update(Member member);
    Member selectOne(String id);
    Member selectOneWithPassword(Map<String,Object> params);
}
