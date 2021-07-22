package com.jdd.sandbox.java.effective.concurrency;

import java.util.concurrent.Callable;

public class SimpleCallableTask implements Callable<String> {

  @Override
  public String call() throws Exception {
    return "concurrency testing";
  }
}
