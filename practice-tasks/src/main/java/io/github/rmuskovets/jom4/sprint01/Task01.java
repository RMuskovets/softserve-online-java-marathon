package io.github.rmuskovets.jom4.sprint01;

class Person_01 {
    int age;
    String healthInfo;
    String name;
    String getHealthStatus() { return name + " " + healthInfo; }

    public Person_01(int age, String name, String healthInfo) {
        this.age = age;
        this.name = name;
        this.healthInfo = healthInfo;
    }
}

class Child_01 extends Person_01 {
    String childIDNumber;

    public Child_01(int age, String name, String healthInfo, String cidn) {
        super(age, name, healthInfo);
        this.childIDNumber = cidn;
    }
}

class Adult_01 extends Person_01 {
    String passportNumber;

    public Adult_01(int age, String name, String healthInfo, String pn) {
        super(age, name, healthInfo);
        this.passportNumber = pn;
    }
}
