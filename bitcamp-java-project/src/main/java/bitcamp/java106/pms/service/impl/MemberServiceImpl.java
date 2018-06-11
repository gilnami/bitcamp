package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.service.MemberService;

public class MemberServiceImpl implements MemberService{
    @Override
    public List<Member> selectList(Map<String, Object> params) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        
        List<Member> list = memberDao.selectList(params);
        return null;
    }
}
