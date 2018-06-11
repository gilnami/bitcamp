package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
    
    TaskDao TaskDao;
    
    public TaskServiceImpl(TaskDao TaskDao) {
        this.TaskDao = TaskDao;
    }
    
    @Override
    public List<Task> list(int pageNo, int pageSize, String teamName) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo - 1) * pageSize);
        params.put("pageSize", pageSize);
        params.put("teamName", teamName);
        
        return TaskDao.selectList(params);
    }
    
    @Override
    public Task get(int no) {
        return TaskDao.selectOne(no);
    }
    
    @Override
    public int add(Task Task) {
        return TaskDao.insert(Task);
    }
    
    @Override
    public int update(Task Task) {
        return TaskDao.update(Task);
    }
    
    @Override
    public int delete(int no) {
        return TaskDao.delete(no);
    }
    
    
}
