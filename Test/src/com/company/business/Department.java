package com.company.business;

public abstract class Department {
    public abstract  int getEmployee();

    public abstract  void method();

    public  void attendence(){
        System.out.println("I am here");
    }
}
class  Department1 extends  Department{
    @Override
    public int getEmployee() {
        return 100;
    }

    @Override
    public void method() {
        System.out.println("This is implementation of method");
    }
}
