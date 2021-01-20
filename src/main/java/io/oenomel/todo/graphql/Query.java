package io.oenomel.todo.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import io.oenomel.todo.task.Task;
import io.oenomel.todo.task.TaskCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    public List<Task> tasks(Long id, String name, String dueDate) {
        var criteria = TaskCriteria.builder()
                .id(id)
                .name(name)
                .dueDate(dueDate)
                .build();
        return null;
    }
}
