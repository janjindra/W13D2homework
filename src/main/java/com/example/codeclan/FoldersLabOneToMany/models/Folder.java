package com.example.codeclan.FoldersLabOneToMany.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "folders")
public class Folder {

    //instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "folder")
    private List<File> files;

    @JsonIgnoreProperties(value = "folders")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //constructor
    public Folder(String title, User user) {
        this.title = title;
        this.files = new ArrayList<>();
        this.user = user;
    }


    //default constructor
    public Folder() {
    }

    //methods
    public void addFileToFilesList(File f){
        this.files.add(f);
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
