package io.oenomel.todo.graphql;

import graphql.kickstart.tools.GraphQLMutationResolver;
import io.oenomel.todo.task.Task;
import io.oenomel.todo.task.TaskInput;
import io.oenomel.todo.task.TaskService;
import io.oenomel.todo.task.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final TaskService taskService;

    public Task saveTask(TaskInput task) {
        return this.taskService.saveTask(task);
    }

    public Task changeTaskStatus(Long id, TaskStatus status) {
        return this.taskService.changeStatus(id, status);
    }
}
