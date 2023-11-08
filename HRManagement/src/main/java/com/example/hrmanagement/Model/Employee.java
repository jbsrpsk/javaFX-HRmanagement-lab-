package com.example.hrmanagement.Model;

public class Employee {
        private int Id;
        private String Name;
        private String Position;
        private int Salary;

        public Employee(int id, String name, String position, int salary) {
            Id = id;
            Name = name;
            Position = position;
            Salary = salary;
        }

        public int getId() {
            return Id;
        }

        public String getName() {
            return Name;
        }

        public String getPosition() {
            return Position;
        }

        public int getSalary() {
            return Salary;
        }
    }


