package com.expandai.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AttributeTest {
  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void askChildrenFromContainer() {
    final Attribute<String, String> underTest = new Attribute<>("KEY");
    assertThat(underTest.children().size(), equalTo(0));
  }

  @Test
  public void comparePassedValues() {
    final String val = "Val";
    final Attribute<String, String> underTest = new Attribute<>("KEY", val);
    assertThat(underTest.value(), equalTo(val));
  }

  @Test
  public void expectExceptionOnAskingSingleForChildren() {
    final Attribute<String, String> underTest = new Attribute<>("KEY", "VAL");
    exception.expect(UnsupportedOperationException.class);
    underTest.children();
  }

  @Test
  public void expectExceptionOnAskingContainerForValue() {
    final Attribute<String, String> underTest = new Attribute<>("KEY");
    exception.expect(UnsupportedOperationException.class);
    underTest.value();
  }

  @Test
  public void testToStringForSingle() {
    final Attribute<String, String> underTest = new Attribute<>("KEY", "VAL");
    assertThat(underTest.toString(), containsString(" :: "));
  }

  @Test
  public void testToStringForContainer() {
    final Attribute<String, String> underTest = new Attribute<>("KEY");
    assertThat(underTest.toString(), not(containsString(" :: ")));
  }
}
