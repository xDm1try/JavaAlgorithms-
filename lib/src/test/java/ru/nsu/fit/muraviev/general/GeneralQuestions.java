package ru.nsu.fit.muraviev.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.fit.muraviev.general.classes.MyKey;
import ru.nsu.fit.muraviev.general.classes.SubClass;
import ru.nsu.fit.muraviev.general.classes.SuperClass;

import java.util.Arrays;
import java.util.HashMap;

public class GeneralQuestions {
  @Test
  public void arrayInitialization(){
    int myArray[] = {1,2,3};
    Arrays.stream(myArray).forEach(x -> System.out.println(x));
  }

  @Test
  public void concatMathod(){
    String x = "abc";
    String y = "ABC";
    x = x.concat(y);
    Assertions.assertTrue(x.equals("abcABC"));
  }

  @Test
  public void stringPoolReferences(){
    String x = "abc";
    String y = "abc";
    Assertions.assertTrue(x == y);
  }

  @Test
  public void extendedMethods(){
    StringBuilder str = new StringBuilder("Hello World!");
    System.out.println(str.toString());
    str.insert(6, "to the ");
    System.out.println(str.toString());
  }

  @Test
  public void testSomething(){
    int a = 10;
    Integer b = 10;
    change(a, b);
    System.out.println("a: " + a);
    System.out.println("b: " + b);
  }
  static public void change(int a, Integer b){
    a = 20;
    b = 20;
  }

  @Test
  public void hashCodeEqualsForMapKeys(){
    var map = new HashMap<MyKey, Integer>();
    MyKey key = new MyKey();
    map.put(new MyKey(), 1);
    map.put(new MyKey(), 2);
    map.put(new MyKey(), 3);
    map.put(null, 4);
    System.out.println("map = " + map);
  }
}
