package io.oenomel.todo.task;

import io.oenomel.todo.config.QuerydslConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@ActiveProfiles("local")
@Import(QuerydslConfiguration.class)
@DataJpaTest
class TaskRepositoryTests {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void saveTest() {
        var task = TaskEntity.builder()
                .name("task01")
                .status(TaskStatus.WAIT)
                .dueDate(LocalDate.of(2021, 12,10))
                .build();
        this.taskRepository.save(task);
        var id = task.getId();
        Assertions.assertTrue(this.taskRepository.findById(id).isPresent());
    }
}
