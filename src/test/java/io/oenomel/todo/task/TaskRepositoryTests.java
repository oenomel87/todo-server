package io.oenomel.todo.task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.time.LocalDate;

@ActiveProfiles("local")
@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TaskRepositoryTests {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void saveTest() {
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
