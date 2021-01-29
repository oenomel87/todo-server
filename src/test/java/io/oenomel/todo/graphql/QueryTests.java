package io.oenomel.todo.graphql;

import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Transactional
@ActiveProfiles("local")
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QueryTests {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    void tasksTest() throws IOException {
        var response = this.graphQLTestTemplate.postForResource("query.graphqls");
        Assertions.assertFalse(response.readTree().get("data").get("tasks").isNull());
    }
}
