package io.oenomel.todo.task;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
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
        return null;
    }
}
