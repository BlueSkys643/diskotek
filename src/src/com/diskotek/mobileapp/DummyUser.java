package com.diskotek.mobileapp;

//intellij wants to change this class to a record which is way more concise for holding only data. Almost too concise.
public class DummyUser implements User{
    //private and final so the variables can't be changed
    private final String username;
    private final DummyRole[] roles;
    private final String password;

    //constructor
    public DummyUser(String username, DummyRole[] roles, String password) {
        this.username = username;
        this.roles = roles;
        this.password = password;
    }

    //public void passwordCheck(DummyUser users) {

    //methods go here
    @Override
    public String getUsername() {
        return username;
    } //returns username

    //returns roles
    @Override
    public DummyRole[] getRoles() {
        return roles;
    }

    @Override
    public String getPassword() { //returns password
        return password;
    }
}