package com.expandai.model;

import java.util.LinkedList;
import java.util.List;

public class Attribute<K, V> {

  private final K key;
  private final V val;
  private final AttributeTypes type;
  private final List<Attribute<K, V>> attributes;

  public Attribute(K key, V val) {
    this.key = key;
    this.val = val;
    this.attributes = null;
    this.type = AttributeTypes.SINGLE;
  }

  public Attribute(K key) {
    this.key = key;
    this.val = null;
    this.attributes = new LinkedList<>();
    this.type = AttributeTypes.CONTAINER;
  }

  public V value() {
    if(this.type == AttributeTypes.SINGLE) {
      return this.val;
    } else {
      throw new UnsupportedOperationException("Container attribute doesn't have value. call #children");
    }
  }

  public List<Attribute<K, V>> children() {
    if(this.type == AttributeTypes.CONTAINER) {
      return this.attributes;
    } else {
      throw new UnsupportedOperationException("Attribute doesn't have children. call #value");
    }
  }

  public void print() {
    this.print("");
  }

  private void print(String prefix) {
    System.out.println(String.format("%s%s", prefix, this.toString()));

    if(this.type == AttributeTypes.CONTAINER) {
      this.attributes.forEach(a -> a.print(prefix + "  "));
    }
  }

  @Override
  public String toString() {
    return this.type == AttributeTypes.SINGLE
      ? String.format("%s :: %s", this.key.toString(), this.val == null ? "" : this.val.toString())
      : String.format("%s", this.key.toString());
  }
}
