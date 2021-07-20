package com.jdd.sandbox.java.effective.lambdas;

import java.util.function.LongSupplier;

@FunctionalInterface
public interface UniformSupplier extends LongSupplier {

  @Override
  public long getAsLong();
}
