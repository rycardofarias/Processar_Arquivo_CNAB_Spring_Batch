package com.example.processar_arq_cnab.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CnabService {

    private final Path fileStorageLocation;

    public CnabService(@Value("${file.upload-dir}") String fileUploadDir){
        this.fileStorageLocation = Paths.get(fileUploadDir);
    }

    public void uploadCnabFile(MultipartFile file) throws Exception {

        var fileName = StringUtils.cleanPath(file.getOriginalFilename());
        var targentLocation = fileStorageLocation.resolve(fileName);

        file.transferTo(targentLocation);
    }
}
