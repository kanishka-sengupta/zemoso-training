package com.company.business;

public class DepartmentDrive {
    public static void main(String[] args) {
        Department1 dept = new Department1();
        System.out.println("Department 1 has "+dept.getEmployee()+" employees.");
        dept.attendence();
    }
}
