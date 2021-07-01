package com.jdd.sandbox.java.vmware;

public class Bowling {

  public String bowlingPins(int[] pins) {

    StringBuilder row4 = new StringBuilder("I I I I\n");
    StringBuilder row3 = new StringBuilder(" I I I \n");
    StringBuilder row2 = new StringBuilder("  I I  \n");
    StringBuilder row1 = new StringBuilder("   I   ");
    StringBuilder[] rows = new StringBuilder[]{row1, row2, row3, row4};
    int pinCnt = 0;

    for (StringBuilder row: rows) {
      char[] chars = row.toString().toCharArray();
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] == 'I') {
          pinCnt++;
          for (int pin: pins) {
            if (pin == pinCnt) {
              row.setCharAt(i, ' ');
            }
          }
        }
      }
    }

    return new String("")
        .concat(row4.toString())
        .concat(row3.toString())
        .concat(row2.toString())
        .concat(row1.toString());
  }
}
