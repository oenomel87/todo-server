package io.oenomel.todo.graphql;

import graphql.kickstart.tools.GraphQLResolver;
import io.oenomel.todo.task.Task;
import io.oenomel.todo.task.TaskService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskResolver implements GraphQLResolver<Task> {

    private final TaskService taskService;

    public TaskResolver(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> subTasks(Task task) {
        return this.taskService.getSubTasks(task);
    }
}
