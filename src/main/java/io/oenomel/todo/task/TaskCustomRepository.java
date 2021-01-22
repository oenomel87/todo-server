package io.oenomel.todo.task;

import java.util.List;

public interface TaskCustomRepository {
    
    List<TaskEntity> findTasks(TaskCriteria criteria);
}
