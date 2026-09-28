package com.Example;

import org.springframework.stereotype.Component;

@Component
public class CoustmmerDetails {
    public  String Name(String name){
        return "hi " + name;
    }
    public  String id(int id){
        return "your id is  " + id;
    }

  public String Salary (double salary){
        return "your salary is "+ salary+1000 ;
  }
}
