package com.example.processar_arq_cnab.controllers;

import com.example.processar_arq_cnab.services.CnabService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cnab")
public class CnabControler {

    private final CnabService cnabService;

    public CnabControler(CnabService cnabService) {
        this.cnabService = cnabService;
    }

    @PostMapping("upload")
    public String upload(@RequestParam ("file")MultipartFile file) throws Exception {
        cnabService.uploadCnabFile(file);
        return "Processamento iniciado!";
    }
}
