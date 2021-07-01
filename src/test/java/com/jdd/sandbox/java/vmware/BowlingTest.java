package com.jdd.sandbox.java.vmware;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTest {

  private Bowling subject;

  @BeforeEach
  public void setup() {
    subject = new Bowling();
  }

  @Test
  public void givenValidArray_returnRemainingPins1() {
    int[] input = new int[]{1, 2, 3};
    String expectedOutput = new String("I I I I\n I I I \n       \n       ");
    String actualOutput = subject.bowlingPins(input);
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void givenValidArray_returnRemainingPins2() {
    int[] input = new int[]{7, 8, 9, 10};
    String expectedOutput = new String("       \n I I I \n  I I  \n   I   ");
    String actualOutput = subject.bowlingPins(input);
    assertEquals(expectedOutput, actualOutput);
  }

  @Test
  public void givenValidArray_returnRemainingPins3() {
    int[] input = new int[]{1, 3, 5, 7};
    String expectedOutput = new String("  I I I\n I   I \n  I    \n       ");
    String actualOutput = subject.bowlingPins(input);
    assertEquals(expectedOutput, actualOutput);
  }

}
