package com.jdd.sandbox.java.effective.lambdas;

import java.util.function.Supplier;

@FunctionalInterface
public interface OldPlayerSupplier extends Supplier<Player> {

    @Override
    Player get();
}
