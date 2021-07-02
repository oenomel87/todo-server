package io.oenomel.todo.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> findTasks(TaskCriteria criteria) {
        var entities = this.taskRepository.findTasks(criteria);
        return entities.stream()
                .map(Task::convert)
                .collect(Collectors.toList());
    }

    public Task findTask(Long id) {
        var task = this.taskRepository.findById(id);
        return task.map(Task::convert).orElse(null);
    }

    public Task saveTask(TaskInput taskInput) {
        var dueDate = taskInput.getDueDate() == null ? null
                : LocalDate.parse(taskInput.getDueDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        var entity = taskInput.getId() == null ?
                TaskEntity.builder()
                    .name(taskInput.getName())
                    .dueDate(dueDate)
                    .status(taskInput.getStatus())
                    .parentTaskId(taskInput.getParentTask())
                    .build()
                : this.taskRepository.findById(taskInput.getId()).orElse(null);

        if(entity == null) {
            return null;
        }

        this.taskRepository.save(entity);
        return Task.convert(entity);
    }

    public Task changeStatus(Long id, TaskStatus status) {
        var task = this.taskRepository.findById(id).orElse(null);
        if(task == null) {
            return null;
        }
        task.setStatus(status);
        this.taskRepository.save(task);
        return Task.convert(task);
    }

    public List<Task> getSubTasks(Task parentTask) {
        var subTasks = this.taskRepository.findByParentTaskId(parentTask.getId());
        return subTasks.stream().map(Task::convert).collect(Collectors.toList());
    }
}
