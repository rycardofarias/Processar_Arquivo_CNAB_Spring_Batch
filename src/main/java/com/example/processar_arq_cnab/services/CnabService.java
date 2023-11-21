package com.example.processar_arq_cnab.services;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CnabService {

    private final Path fileStorageLocation;
    private final JobLauncher jobLauncher;
    private final Job job;

    public CnabService(@Value("${file.upload-dir}") String fileUploadDir,
                       @Qualifier("jobLauncherAsync")
                       JobLauncher jobLauncher, Job job){

        this.fileStorageLocation = Paths.get(fileUploadDir);
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    public void uploadCnabFile(MultipartFile file) throws Exception {

        var fileName = StringUtils.cleanPath(file.getOriginalFilename());
        var targentLocation = fileStorageLocation.resolve(fileName);

        file.transferTo(targentLocation);

        var jobParameters = new JobParametersBuilder()
                .addJobParameter("cnab", file.getOriginalFilename(),
                        String.class, true)
                .addJobParameter("cnabFile", "file:" + targentLocation.toString(),
                        String.class)
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
    }
}
