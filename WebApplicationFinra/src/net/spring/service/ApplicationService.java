package net.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.spring.FileInfo.FileVo;

public interface ApplicationService {
    FileVo saveFile(MultipartFile file, FileVo metaData);
    List<FileVo> searchFileBy(String keyword);
}
