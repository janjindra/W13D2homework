package com.example.codeclan.FoldersLabOneToMany.repositories;

import com.example.codeclan.FoldersLabOneToMany.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
