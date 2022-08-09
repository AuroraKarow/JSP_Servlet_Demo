package entity;

public class person {
    private String name = "";
    private String age = "";
    private String gender = "";
    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }
    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }/**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }/**
     * @return the age
     */
    public String getAge() {
        return age;
    }/**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }/**
     * @return the name
     */
    public String getName() {
        return name;
    }
}