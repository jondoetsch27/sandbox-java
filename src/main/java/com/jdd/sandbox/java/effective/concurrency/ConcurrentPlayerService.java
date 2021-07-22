package com.jdd.sandbox.java.effective.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ConcurrentPlayerService {

  private static final ExecutorService executorService = Executors.newCachedThreadPool();

  public void executeRunnableTask(Runnable task) {
    executorService.submit(task);
    try {
      executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
      executorService.shutdown();
    } catch (InterruptedException exception) {
      throw new RuntimeException(exception);
    }
  }

  public void executeMultipleRunnableTasks(Runnable[] tasks) {
    for (Runnable task : tasks) {
      executorService.submit(task);
    }
  }

  public void executeCallableTask(Callable<String> task) {
    Future<String> stringFuture = executorService.submit(task);
    try {
      System.out.println(stringFuture.get());
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    }
  }

  public void executeMultipleCallableTasks(List<Callable<String>> tasks) {
    try {
      List<Future<String>> futures = executorService.invokeAll(tasks);
      futures.forEach(
          (future) -> {
            try {
              System.out.println(future.get());
            } catch (Exception exception) {
              throw new RuntimeException(exception);
            }
          });
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    }
  }

  public void executeMultiplePlayerTasks(List<Callable<Player>> playerTasks) {
    try {
      List<Future<Player>> futures = executorService.invokeAll(playerTasks);
      futures.forEach(
          (future) -> {
            try {
              System.out.println(future.get());
            } catch (Exception exception) {
              throw new RuntimeException(exception);
            }
          });
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    }
  }
}
