package io.oenomel.todo.task;

import lombok.*;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task implements Serializable {

    private static final long serialVersionUID = -6681699193895080330L;

    private Long id;

    private String name;

    private TaskStatus status;

    private String dueDate;

    private String createdAt;

    private String updatedAt;

    public static Task convert(TaskEntity e) {
        var dueDate = e.getDueDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        var datetimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Task.builder()
                .id(e.getId())
                .name(e.getName())
                .status(e.getStatus())
                .dueDate(dueDate)
                .createdAt(e.getCreatedAt().format(datetimeFormat))
                .updatedAt(e.getUpdatedAt().format(datetimeFormat))
                .build();
    }
}
