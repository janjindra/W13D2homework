package com.example.codeclan.FoldersLabOneToMany.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    //instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Folder> folders;

    //constructor
    public User(String name) {
        this.name = name;
        this.folders = new ArrayList<>();
    }

    //default constructor

    public User() {
    }

    //methods
    public void addFolderToFoldersList(Folder f){
        this.folders.add(f);
    }

    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
