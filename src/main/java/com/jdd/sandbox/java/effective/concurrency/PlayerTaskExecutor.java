package com.jdd.sandbox.java.effective.concurrency;

import java.util.concurrent.Executor;

public class PlayerTaskExecutor implements Executor {

  @Override
  public void execute(Runnable command) {
    command.run();
  }
}
