package com.expandai;

import com.expandai.model.Attribute;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    final Attribute<String, String> A = new Attribute<>("");

    final Attribute<String, String> as1 = new Attribute<>("Attributes 1");
    as1.children().add(new Attribute<>("Attribute 1", "Value 1"));
    as1.children().add(new Attribute<>("Attribute 2", "Value 2"));

    final Attribute<String, String> a3 = new Attribute<>("Attribute 3", "Value 3");

    final Attribute<String, String> as2 = new Attribute<>("Attributes2");
    final Attribute<String, String> as3 = new Attribute<>("Attributes3");
    as3.children().add(new Attribute<>("Attribute 4", "Value 4"));
    as2.children().add(as3);
    as2.children().add(new Attribute<>("Attribute 5", "Value 5"));

    A.children().addAll(Arrays.asList(as1, a3, as2));

    A.print();
  }
}
