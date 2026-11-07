
package com.example.task.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.example.task.entity.Task;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testTaskPersistence() {

        Task task = new Task(
            "Complete Assignment",
            "Spring Boot Repository Testing"
        );

        Task savedTask = taskRepository.save(task);

        assertNotNull(savedTask.getId());

        Task foundTask = taskRepository.findById(
            savedTask.getId()
        ).orElse(null);

        assertNotNull(foundTask);

        assertEquals("Complete Assignment", foundTask.getTitle());

        System.out.println("Task saved successfully!");
        System.out.println("Generated ID: " + foundTask.getId());
    }
}
