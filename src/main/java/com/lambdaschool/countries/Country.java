package com.lambdaschool.countries;

public class Country
{
    private static String name;
    private static long population;
    private static long size;
    private static int age;

    public Country(String name, long population, long size, int age)
    {
        this. name = name;
        this.population = population;
        this.size = size;
        this.age = age;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Country.name = name;
    }

    public static long getPopulation() {
        return population;
    }

    public static void setPopulation(long population) {
        Country.population = population;
    }

    public static long getSize() {
        return size;
    }

    public static void setSize(long size) {
        Country.size = size;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Country.age = age;
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
