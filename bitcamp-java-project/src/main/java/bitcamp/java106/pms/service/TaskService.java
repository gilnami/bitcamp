package bitcamp.java106.pms.service;

import java.util.List;

import bitcamp.java106.pms.domain.Task;

public interface TaskService {
    int delete(int no);
    List<Task> list(int pageNo, int pageSize, String teamName);
    int add(Task task);
    int update(Task task);
    Task get(int no);
}
