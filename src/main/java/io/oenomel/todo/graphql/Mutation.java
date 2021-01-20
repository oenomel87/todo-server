package io.oenomel.todo.graphql;

import graphql.kickstart.tools.GraphQLMutationResolver;
import io.oenomel.todo.task.Task;
import io.oenomel.todo.task.TaskInput;
import io.oenomel.todo.task.TaskStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    public Task saveTask(TaskInput task) {
        return null;
    }

    public Task changeTaskStatus(Long id, TaskStatus status) {
        return null;
    }
}
