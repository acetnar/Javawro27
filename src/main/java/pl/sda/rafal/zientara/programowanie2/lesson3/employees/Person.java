package pl.sda.rafal.zientara.programowanie2.lesson3.employees;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class Person implements Comparable<Person>{
    private String firstName;
    private String secondName;
    private int age;
    private int numberOfEmployees;
    private List<Person> listOfEmployees = new ArrayList<>();

    public Person() {
    }

    public Person(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public void getAllInformationFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of employee to create: ");
        this.numberOfEmployees = scanner.nextInt();
        for (int i = 0; i < numberOfEmployees; i++) {
            scanner.nextLine();
            System.out.println("Enter first name of employee: ");
            this.firstName = scanner.nextLine();
            System.out.println("Enter second name of employee: ");
            this.secondName = scanner.nextLine();
            System.out.println("Enter age of employee: ");
            this.age = scanner.nextInt();
            Person newPerson = createPerson(this.firstName, this.secondName, this.age);
            listOfEmployees.add(newPerson);
        }
        for (Person person : listOfEmployees) {
            System.out.println(person.toString());
        }
    }

    private Person createPerson(String firstName, String secondName, int age) {
        Person person = new Person(this.firstName, this.secondName, this.age);
        return person;
    }

    public String getData(){
        return getFirstName()+';'+getSecondName()+';'+getAge();
    };

///TODO How to save it??????
//    public void saveAsCsv() throws IOException {
//        FileOutputStream fos = new FileOutputStream("baza.csv");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(listOfEmployees);
//        oos.close();
//    }



    @Override
    public String toString() {
        return "Dane: " + firstName + ", " + secondName + ", " +  age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return this.getSecondName().compareTo(o.secondName);
    }
}
