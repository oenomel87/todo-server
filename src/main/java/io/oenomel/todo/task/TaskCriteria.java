package io.oenomel.todo.task;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskCriteria {

    private Long id;

    private String name;

    private String dueDate;
}
