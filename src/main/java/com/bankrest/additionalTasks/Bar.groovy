package com.bankrest.additionalTasks

class Bar {
    private String name;
    private String secondName;

    Bar(String name, String secondName) {
        this.name = name
        this.secondName = secondName
    }

    @Override
    public String toString() {
        return "Bar{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
