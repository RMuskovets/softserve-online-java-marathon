package io.github.rmuskovets.jom4.sprint00;

class Employee_03 {
    private String fullName;
    private float salary;

    public Employee_03() { this("", 0.0f); }

    public Employee_03(String fn, float s) {
        fullName = fn;
        salary = s;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String s) { fullName = s; }

    public float getSalary() { return salary; }
    public void setSalary(float f) { salary = f; }
}