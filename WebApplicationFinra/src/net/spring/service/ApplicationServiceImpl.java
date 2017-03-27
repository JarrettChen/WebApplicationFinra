package net.spring.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import net.spring.entity.Metadata;
import net.spring.exception.UploadException;
import net.spring.repo.Repo;
import net.spring.save.FileSaver;
import net.spring.FileInfo.FileVo;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private Repo fileRepo;
    
    @Autowired
    private FileSaver fileSaver;

    @Override
    @Transactional
    public FileVo saveFile(MultipartFile file, FileVo metaData) {
        Metadata fileData = new Metadata(metaData);
        LOG.info(file + " " + file.getContentType());
        fileRepo.save(fileData);
        
        
        try {
			fileSaver.saveFile(file.getBytes(), fileData.getDocId());
		} catch (IOException e) {
			throw new UploadException(e);
		}
        return metaData;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FileVo> searchFileBy(String keyword) {
        List<Metadata> entityList = fileRepo.findByFileNameOrUserId(keyword);
        List<FileVo> resList = new ArrayList<>();
        for (Metadata data : entityList) {
            resList.add(new FileVo(data.getId(),data.getUserId(),data.getUploadTime(),data.getFileName(),data.getDocId()));
        }
        return resList;
    }
}
