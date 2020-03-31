package com.example.codeclan.FoldersLabOneToMany.controllers;

import com.example.codeclan.FoldersLabOneToMany.models.File;
import com.example.codeclan.FoldersLabOneToMany.models.Folder;
import com.example.codeclan.FoldersLabOneToMany.repositories.FileRepository;
import com.example.codeclan.FoldersLabOneToMany.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getFolders(@PathVariable Long id){
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/folders")
    public ResponseEntity postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity(folder, HttpStatus.CREATED);
    }

}