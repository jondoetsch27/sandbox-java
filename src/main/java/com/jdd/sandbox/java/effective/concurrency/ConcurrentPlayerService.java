package com.jdd.sandbox.java.effective.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentPlayerService {

  private static final Executor executor;
  private static final ExecutorService executorService;

  static {
    executor = new PlayerTaskExecutor();
    executorService = Executors.newCachedThreadPool();
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

  public void executeTaskWithExecutor(Runnable task) {
    executorService.submit(task);
    try {
      executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
      executorService.shutdown();
    } catch (InterruptedException exception) {
      throw new RuntimeException(exception);
    }
  }
}
