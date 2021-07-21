package com.jdd.sandbox.java.effective.concurrency;

import java.util.Random;

public class PlayerTask implements Runnable {

  @Override
  public void run() {
    try {
      Thread.sleep(new Random().nextInt(5000));
    } catch (InterruptedException exception) {
      throw new RuntimeException(exception);
    }
    System.out.println("PlayerTask.run()");
  }
}
