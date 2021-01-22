package io.oenomel.todo.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import io.oenomel.todo.task.Task;
import io.oenomel.todo.task.TaskCriteria;
import io.oenomel.todo.task.TaskService;
import io.oenomel.todo.task.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final TaskService taskService;

    public List<Task> tasks(String name, TaskStatus status, String dueDate) {
        var criteria = TaskCriteria.builder()
                .name(name)
                .status(status)
                .dueDate(dueDate)
                .build();
        return this.taskService.findTasks(criteria);
    }

    public Task task(Long id) {
        return this.taskService.findTask(id);
    }
}
