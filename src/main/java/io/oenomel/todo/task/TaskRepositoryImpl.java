package io.oenomel.todo.task;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
public class TaskRepositoryImpl extends QuerydslRepositorySupport implements TaskCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager entityManager;

    public TaskRepositoryImpl(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(TaskEntity.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

    public List<TaskEntity> findTasks(TaskCriteria criteria) {
        var task = QTaskEntity.taskEntity;
        return this.jpaQueryFactory.selectFrom(task)
                .where(this.likeName(criteria), this.eqStatus(criteria), this.compareWithDueDate(criteria))
                .fetch();
    }

    private BooleanExpression likeName(TaskCriteria criteria) {
        var name = criteria.getName();
        return name != null && !name.isEmpty() ? QTaskEntity.taskEntity.name.like(name) : null;
    }

    private BooleanExpression eqStatus(TaskCriteria criteria) {
        var status = criteria.getStatus();
        return status != null ? QTaskEntity.taskEntity.status.eq(status) : null;
    }

    private BooleanExpression compareWithDueDate(TaskCriteria criteria) {
        var dueDate = criteria.getDueDate();
        var dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dueDate != null && !dueDate.isEmpty() ? QTaskEntity.taskEntity.dueDate.eq(LocalDate.parse(dueDate, dateFormat)) : null;
    }
}
