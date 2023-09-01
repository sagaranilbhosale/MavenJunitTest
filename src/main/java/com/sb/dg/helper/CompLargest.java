package com.sb.dg.helper;

import java.util.Comparator;

public class CompLargest implements Comparator<String> {
       @Override
    public int compare(String o1, String o2) {
          String o12 = o1+o2;
          String o21 = o2+o1;
          return o21.compareTo(o12);
    }
}
