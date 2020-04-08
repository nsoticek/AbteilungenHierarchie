package com.company;

public class Department {

    private String name;
    private Person[] persons = new Person[5];
    Department[] departments = new Department[10];
    int departmentCounter;
    private int personCounter;

    public Department(String name) {
        this.name = name;
    }

    public void addSubdepartment(Department department) {
        this.departments[departmentCounter] = department;
        departmentCounter++;
    }

    public void addPerson(Person person) {
        persons[personCounter] = person;
        personCounter++;
    }

    private void getDepartmentName(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("\t");
        }
        System.out.print(name + " ");
        for (int i = 0; i < personCounter; i++) {
            System.out.print(persons[i].getName()+ " ");
        }
        System.out.println();
    }

    public void getDepartmentTree(int indent) {
        getDepartmentName(indent);
        indent++;
        for (int i = 0; i < departmentCounter; i++) {
            departments[i].getDepartmentTree(indent);
        }
    }

    public String getName() {
        return name;
    }
}
