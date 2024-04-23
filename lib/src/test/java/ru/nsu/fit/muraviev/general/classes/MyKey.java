package ru.nsu.fit.muraviev.general.classes;

public class MyKey {

  @Override
  public int hashCode(){
    return 1;
  }

  @Override
  public boolean equals(Object obj){
    return false;
  }
  @Override
  public String toString(){
    return "MyKey()";
  }
}
