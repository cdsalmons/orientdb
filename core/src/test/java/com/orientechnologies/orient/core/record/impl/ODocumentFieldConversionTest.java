package com.orientechnologies.orient.core.record.impl;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.math.BigDecimal;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orientechnologies.orient.core.db.document.ODatabaseDocument;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;

public class ODocumentFieldConversionTest {

  private ODatabaseDocument db;
  private OClass            clazz;

  @BeforeTest
  public void before() {
    db = new ODatabaseDocumentTx("memory:" + this.getClass().getSimpleName());
    db.create();
    clazz = db.getMetadata().getSchema().createClass("testClass");
    clazz.createProperty("integer", OType.INTEGER);
    clazz.createProperty("string", OType.STRING);
    clazz.createProperty("boolean", OType.BOOLEAN);
    clazz.createProperty("long", OType.LONG);
    clazz.createProperty("float", OType.FLOAT);
    clazz.createProperty("double", OType.DOUBLE);
    clazz.createProperty("decimal", OType.DECIMAL);

  }

  @Test
  public void testLiteralToSchemaConvertionInteger() {
    ODocument doc = new ODocument(clazz);
    doc.field("integer", 2L);
    assertTrue(doc.field("integer") instanceof Integer);
    assertEquals(2, doc.field("integer"));

    doc.field("integer", 3f);
    assertTrue(doc.field("integer") instanceof Integer);
    assertEquals(3, doc.field("integer"));

    doc.field("integer", 4d);
    assertTrue(doc.field("integer") instanceof Integer);
    assertEquals(4, doc.field("integer"));

    doc.field("integer", "5");
    assertTrue(doc.field("integer") instanceof Integer);
    assertEquals(5, doc.field("integer"));

    doc.field("integer", new BigDecimal("6"));
    assertTrue(doc.field("integer") instanceof Integer);
    assertEquals(6, doc.field("integer"));

    // doc.field("integer", true);
    // assertTrue(doc.field("integer") instanceof Integer);
    // assertEquals(1, doc.field("integer"));

  }

  @Test
  public void testLiteralToSchemaConvertionString() {
    ODocument doc = new ODocument(clazz);

    doc.field("string", 1);
    assertTrue(doc.field("string") instanceof String);
    assertEquals("1", doc.field("string"));

    doc.field("string", 2L);
    assertTrue(doc.field("string") instanceof String);
    assertEquals("2", doc.field("string"));

    doc.field("string", 3f);
    assertTrue(doc.field("string") instanceof String);
    assertEquals("3.0", doc.field("string"));

    doc.field("string", 4d);
    assertTrue(doc.field("string") instanceof String);
    assertEquals("4.0", doc.field("string"));

    doc.field("string", new BigDecimal("6"));
    assertTrue(doc.field("string") instanceof String);
    assertEquals("6", doc.field("string"));

    doc.field("string", true);
    assertTrue(doc.field("string") instanceof String);
    assertEquals("true", doc.field("string"));

  }

  @Test
  public void testLiteralToSchemaConvertionFloat() {
    ODocument doc = new ODocument(clazz);

    doc.field("float", 1);
    assertTrue(doc.field("float") instanceof Float);
    assertEquals(1f, doc.field("float"));

    doc.field("float", 2L);
    assertTrue(doc.field("float") instanceof Float);
    assertEquals(2f, doc.field("float"));

    doc.field("float", "3");
    assertTrue(doc.field("float") instanceof Float);
    assertEquals(3f, doc.field("float"));

    doc.field("float", 4d);
    assertTrue(doc.field("float") instanceof Float);
    assertEquals(4f, doc.field("float"));

    doc.field("float", new BigDecimal("6"));
    assertTrue(doc.field("float") instanceof Float);
    assertEquals(6f, doc.field("float"));

    // doc.field("float", true);
    // assertTrue(doc.field("float") instanceof Float);
    // assertEquals(1f, doc.field("float"));
  }

  @Test
  public void testLiteralToSchemaConvertionDouble() {
    ODocument doc = new ODocument(clazz);

    doc.field("double", 1);
    assertTrue(doc.field("double") instanceof Double);
    assertEquals(1d, doc.field("double"));

    doc.field("double", 2L);
    assertTrue(doc.field("double") instanceof Double);
    assertEquals(2d, doc.field("double"));

    doc.field("double", "3");
    assertTrue(doc.field("double") instanceof Double);
    assertEquals(3d, doc.field("double"));

    doc.field("double", 4f);
    assertTrue(doc.field("double") instanceof Double);
    assertEquals(4d, doc.field("double"));

    doc.field("double", new BigDecimal("6"));
    assertTrue(doc.field("double") instanceof Double);
    assertEquals(6d, doc.field("double"));

    // doc.field("double", true);
    // assertTrue(doc.field("double") instanceof Double);
    // assertEquals(1d, doc.field("double"));
  }

  @Test
  public void testLiteralToSchemaConvertionLong() {
    ODocument doc = new ODocument(clazz);

    doc.field("long", 1);
    assertTrue(doc.field("long") instanceof Long);
    assertEquals(1L, doc.field("long"));

    doc.field("long", 2f);
    assertTrue(doc.field("long") instanceof Long);
    assertEquals(2L, doc.field("long"));

    doc.field("long", "3");
    assertTrue(doc.field("long") instanceof Long);
    assertEquals(3L, doc.field("long"));

    doc.field("long", 4d);
    assertTrue(doc.field("long") instanceof Long);
    assertEquals(4L, doc.field("long"));

    doc.field("long", new BigDecimal("6"));
    assertTrue(doc.field("long") instanceof Long);
    assertEquals(6L, doc.field("long"));

    // doc.field("long", true);
    // assertTrue(doc.field("long") instanceof Long);
    // assertEquals(1, doc.field("long"));
  }

  @Test
  public void testLiteralToSchemaConvertionBoolean() {
    ODocument doc = new ODocument(clazz);

    doc.field("boolean", 0);
    assertTrue(doc.field("boolean") instanceof Boolean);
    assertEquals(false, doc.field("boolean"));

    doc.field("boolean", 1L);
    assertTrue(doc.field("boolean") instanceof Boolean);
    assertEquals(true, doc.field("boolean"));

    doc.field("boolean", 2f);
    assertTrue(doc.field("boolean") instanceof Boolean);
    assertEquals(true, doc.field("boolean"));

    doc.field("boolean", "true");
    assertTrue(doc.field("boolean") instanceof Boolean);
    assertEquals(true, doc.field("boolean"));

    doc.field("boolean", 4d);
    assertTrue(doc.field("boolean") instanceof Boolean);
    assertEquals(true, doc.field("boolean"));

    doc.field("boolean", new BigDecimal("6"));
    assertTrue(doc.field("boolean") instanceof Boolean);
    assertEquals(true, doc.field("boolean"));

  }

  @Test
  public void testLiteralToSchemaConvertionDecimal() {
    ODocument doc = new ODocument(clazz);

    doc.field("decimal", 0);
    assertTrue(doc.field("decimal") instanceof BigDecimal);
    assertEquals(BigDecimal.ZERO, doc.field("decimal"));

    doc.field("decimal", 1L);
    assertTrue(doc.field("decimal") instanceof BigDecimal);
    assertEquals(BigDecimal.ONE, doc.field("decimal"));

    doc.field("decimal", 2f);
    assertTrue(doc.field("decimal") instanceof BigDecimal);
    assertEquals(new BigDecimal("2.0"), doc.field("decimal"));

    doc.field("decimal", "3");
    assertTrue(doc.field("decimal") instanceof BigDecimal);
    assertEquals(new BigDecimal("3"), doc.field("decimal"));

    doc.field("decimal", 4d);
    assertTrue(doc.field("decimal") instanceof BigDecimal);
    assertEquals(new BigDecimal("4.0"), doc.field("decimal"));

    doc.field("boolean", new BigDecimal("6"));
    assertTrue(doc.field("boolean") instanceof Boolean);
    assertEquals(true, doc.field("boolean"));
  }

  @Test
  public void testConversionAlsoWithWrongType() {
    ODocument doc = new ODocument(clazz);

    doc.field("float", 2, OType.INTEGER);
    assertTrue(doc.field("float") instanceof Float);
    assertEquals(2f, doc.field("float"));

    doc.field("integer", 3f, OType.FLOAT);
    assertTrue(doc.field("integer") instanceof Integer);
    assertEquals(3, doc.field("integer"));

    doc.field("double", 1l, OType.LONG);
    assertTrue(doc.field("double") instanceof Double);
    assertEquals(1d, doc.field("double"));

    doc.field("long", 1d, OType.DOUBLE);
    assertTrue(doc.field("long") instanceof Long);
    assertEquals(1L, doc.field("long"));

  }

  // @Test
  public void testLiteralSetSchemaAfter() {
    ODocument doc = new ODocument();

    doc.field("float", 1);
    doc.setClassName(clazz.getName());
    assertTrue(doc.field("float") instanceof Float);
    assertEquals(2, doc.field("float"));
  }

  @AfterTest
  public void after() {
    db.drop();
  }

}