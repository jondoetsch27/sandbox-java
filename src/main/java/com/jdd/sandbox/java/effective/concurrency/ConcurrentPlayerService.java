package com.jdd.sandbox.java.effective.concurrency;

import java.util.concurrent.Executor;

public class ConcurrentPlayerService {

  private static final Executor executor;

  static {
    executor = new PlayerTaskExecutor();
  }

  public void executeTask() {
    executor.execute(
        () -> {
          System.out.println("Test");
        });
  }

  public void executeMultipleTasks(Runnable[] tasks) {
    Thread firstTask = new Thread(tasks[0]);
    Thread secondTask = new Thread(tasks[1]);
    System.out.println("Starting task: " + tasks[0].getClass());
    firstTask.start();
    System.out.println("Starting task: " + tasks[1].getClass());
    secondTask.start();
    try {
      firstTask.join();
      secondTask.join();
    } catch (InterruptedException exception) {
      throw new RuntimeException(exception);
    }
  }
}
