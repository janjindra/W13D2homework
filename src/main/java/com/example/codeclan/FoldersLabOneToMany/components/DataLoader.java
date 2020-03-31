package com.example.codeclan.FoldersLabOneToMany.components;


import com.example.codeclan.FoldersLabOneToMany.models.File;
import com.example.codeclan.FoldersLabOneToMany.models.Folder;
import com.example.codeclan.FoldersLabOneToMany.models.User;
import com.example.codeclan.FoldersLabOneToMany.repositories.FileRepository;
import com.example.codeclan.FoldersLabOneToMany.repositories.FolderRepository;
import com.example.codeclan.FoldersLabOneToMany.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        User jan = new User("Jan");
        User peter = new User("Peter");
        User john = new User("John");
        userRepository.save(jan);
        userRepository.save(peter);
        userRepository.save(john);
        Folder w13d1 = new Folder("W13D1", jan);
        Folder w12d1 = new Folder("W12D1", peter);
        Folder w12d3 = new Folder("W12D3", peter);
        folderRepository.save(w12d1);
        folderRepository.save(w12d3);
        folderRepository.save(w13d1);
        File pirateLab = new File("PirateLab", ".java", 400,w13d1);
        File fantasyLab = new File("FantasyLab", ".java", 300,w12d3);
        File musicShop = new File("MusicShop", ".java", 300,w12d1);
        fileRepository.save(pirateLab);
        fileRepository.save(fantasyLab);
        fileRepository.save(musicShop);

        jan.addFolderToFoldersList(w12d1);
        jan.addFolderToFoldersList(w13d1);
        john.addFolderToFoldersList(w13d1);
        userRepository.save(jan);
        userRepository.save(john);

        w12d1.addFileToFilesList(pirateLab);
        w12d1.addFileToFilesList(musicShop);
        w13d1.addFileToFilesList(fantasyLab);
        folderRepository.save(w12d1);
        folderRepository.save(w13d1);

    }
}
