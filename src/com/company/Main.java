package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Department[] departments = new Department[30];
        int departmentCounter = 0;
        String myFile = "C:\\Users\\DCV\\Desktop\\TextDateien\\Abteilungen1.txt";
        Department department = null;

        try {
            FileReader reader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedValues = line.split(";");

                String parentDepartmentValue = null;
                department = null;
                boolean isExistingDepartment = false;

                String name = splittedValues[0];
                String departmentValue = splittedValues[1];
                if (splittedValues.length > 2)
                    parentDepartmentValue = splittedValues[2];

                Person person = new Person(name);

                // check if the current department exists -if not return false
                for (int i = 0; i < departmentCounter; i++) {
                    if (departments[i].getName().equalsIgnoreCase(departmentValue)) {
                        isExistingDepartment = true;
                        department = departments[i];
                        break;
                    }
                }

                // create new department !notExists
                if (!isExistingDepartment) {
                    department = new Department(departmentValue);
                    departments[departmentCounter] = department;
                    departmentCounter++;
                }

                // add subdepartment to parent department
                if (splittedValues.length > 2) {
                    for (int i = 0; i < departmentCounter; i++) {
                        if (departments[i].getName().equalsIgnoreCase(parentDepartmentValue)) {
                            if (!isExistingDepartment) {
                                departments[i].addSubdepartment(department);
                                break;
                            }
                        }
                    }
                }
                department.addPerson(person);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        departments[1].getDepartmentTree(0);
    }
}
