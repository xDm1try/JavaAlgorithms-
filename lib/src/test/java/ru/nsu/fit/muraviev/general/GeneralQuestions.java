package ru.nsu.fit.muraviev.general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nsu.fit.muraviev.general.Classes.SubClass;
import ru.nsu.fit.muraviev.general.Classes.SuperClass;

import java.util.Arrays;

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
    SuperClass superClass = new SuperClass();
    superClass.foo();


    SubClass subClass = new SubClass();
    subClass.foo();

    SuperClass supCasted = (SuperClass) subClass;
    supCasted.foo();

  }
}
