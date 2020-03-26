package ru.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.Dto.UserConfirmDto;
import ru.itis.service.UploadFileService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;


@Component
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired
    private Environment environment;

    @Override
    public void saveFile(MultipartFile file, UserConfirmDto user) {

        String name = file.getOriginalFilename();
        String[] all = name.split("\\.");
        String allName = environment.getProperty("storage.path") + "/" + name;
        try {
            file.transferTo(Paths.get(allName));
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
        /*String pathDir ="uploads";
        File dir = new File(pathDir);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String filename = file.getOriginalFilename();

        try {
            byte[] bytes = file.getBytes();
            File loadFile = new File(dir.getAbsolutePath() + File.separator + filename);
            System.out.println(loadFile.getAbsolutePath());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
            stream.write(bytes);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }*/

    }


    @Override
    public File findFile(String fileName) {
        String path = environment.getProperty("storage.path") + "/" + fileName;
        return new File(path);
    }

}
