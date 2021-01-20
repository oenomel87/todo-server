package io.oenomel.todo.task;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskInput implements Serializable {

    private static final long serialVersionUID = 1146356286694171948L;

    private Long id;

    private String name;

    private TaskStatus status;

    private String dueDate;
}
