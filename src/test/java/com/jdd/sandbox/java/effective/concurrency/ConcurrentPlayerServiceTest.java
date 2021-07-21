package com.jdd.sandbox.java.effective.concurrency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConcurrentPlayerServiceTest {

  private ConcurrentPlayerService subject;

  @BeforeEach
  public void setUp() {
    subject = new ConcurrentPlayerService();
  }

  @Test
  public void executeTaskTest() {
    subject.executeTask();
  }
}
