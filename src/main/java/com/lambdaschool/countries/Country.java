package com.lambdaschool.countries;

public class Country
{
    private String name;
    private long population;
    private long size;
    private int age;

    public Country(String name, long population, long size, int age)
    {
        this.name = name;
        this.population = population;
        this.size = size;
        this.age = age;
    }

    public Country(Country toClone)
    {
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.size = toClone.getSize();
        this.age = toClone.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", size=" + size +
                ", age=" + age +
                '}';
    }
}
