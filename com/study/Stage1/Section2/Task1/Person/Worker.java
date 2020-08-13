package com.study.Stage1.Section2.Task1.Person;

public class Worker extends Person{

    private int salary;

    Worker(){}
    Worker(String name, int age, int salary){
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if(salary >= 2200){
            this.salary = salary;
        }else{
            System.out.println("薪水不合适");
        }
    }

    public void work(){

        System.out.println("搬砖");
    }

    @Override
    public void show() {
        super.show();
        System.out.println("薪水: " + getSalary());
    }
}
