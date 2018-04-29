package com.expandai.model;

import java.util.LinkedList;
import java.util.List;

/*
 * This is the model which is used to store information about product attributes.
 * According to requirements it is a nested structure which could store simple key-value attributes
 * as well as more complex nested objects.
 * I do not have feeling that provided solution is the best one, yet it solves the problem and I didn't come up
 * with anything much better than what is presented here.
 *
 * I decided to combine two types of attributes inside one class:
 * * SINGLE - Simple key value storage.
 * * CONTAINER - Complex storage with key and a collection of attributes.
 * Which type of container is active we determine by used constructor.
 *
 * Sure there is a room for API improvement. First calls:
 * * Hide direct access to `Attribute.attributes` field. The best option would be to create abstraction layer which
 *     will encapsulate manipulation with collection.
 * * Extend amount of constructors. For example, allowing passing lists for attribute groups.
 * * Sorting. In task it is pointed that 'Attribute 3' goes before 'Attributes 2'.
 *     In my case it solved simply by adding attributes in predefined order. If sorting is required I need to know
 *     what is a sorting value(internal index, key name, etc.) and implement Comparable interface.
 */
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

  public K key() {
    return key;
  }

  public V value() {
    // If system requests value from single component type - we return it. Otherwise exception is thrown.
    if(this.type == AttributeTypes.SINGLE) {
      return this.val;
    } else {
      throw new UnsupportedOperationException("Container attribute doesn't have value. call #children");
    }
  }

  public List<Attribute<K, V>> children() {
    // If system requests childrens from container component type - we return it. Otherwise exception is thrown.
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
