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
    for (Runnable task: tasks) {
      task.run();
    }
  }
}
