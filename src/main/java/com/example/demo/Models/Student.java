package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "disciples")
public class Student {

    @Id
    private String _id;
//    private String id;
    private String name;
    private String address;

    // Constructors
    public Student() {}

    public Student(String _id, String name, String address) {
        this._id = _id;
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [_id=" + _id + ", name=" + name + ", address=" + address + "]";
    }
}
