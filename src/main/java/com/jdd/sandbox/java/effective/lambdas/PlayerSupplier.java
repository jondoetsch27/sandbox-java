package com.jdd.sandbox.java.effective.lambdas;

import java.util.function.Supplier;

@FunctionalInterface
public interface PlayerSupplier extends Supplier {

    @Override
    Player get();
}
