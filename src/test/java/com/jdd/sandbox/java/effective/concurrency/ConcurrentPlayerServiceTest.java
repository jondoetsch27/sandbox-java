package com.jdd.sandbox.java.effective.concurrency;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConcurrentPlayerServiceTest {

  private ConcurrentPlayerService subject;

  @BeforeEach
  public void setUp() {
    subject = new ConcurrentPlayerService();
  }

  @Test
  public void executeRunnableTasksTest() {
    var tasks =
        new Runnable[] {
          new CoachTask(), new PlayerTask(),
        };
    subject.executeMultipleRunnableTasks(tasks);
  }

  @Test
  public void executeRunnableTaskTest() {
    subject.executeRunnableTask(new PlayerTask());
  }

  @Test
  public void executeCallableTaskTest() {
    var callableTask = new SimpleCallableTask();
    subject.executeCallableTask(callableTask);
  }

  @Test
  public void executeMultipleCallableTasksTest() {
    var callableTasks =
        new SimpleCallableTask[] {
          new SimpleCallableTask(),
          new SimpleCallableTask(),
          new SimpleCallableTask(),
          new SimpleCallableTask(),
          new SimpleCallableTask()
        };
    subject.executeMultipleCallableTasks(Stream.of(callableTasks).collect(Collectors.toList()));
  }
}
