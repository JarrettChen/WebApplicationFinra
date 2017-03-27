package net.spring.controller;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.spring.service.ApplicationService;
import net.spring.FileInfo.FileVo;

@RestController
@RequestMapping(value="/file")
public class Controller {
    private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private ApplicationService fileService;

    @RequestMapping(value = "",method=RequestMethod.POST, produces = "application/json")
    public FileVo uploadFile(@RequestParam MultipartFile file, @RequestParam String userId){
        FileVo metaData = new FileVo();
        metaData.setUploadTime(new Date());
        metaData.setUserId(userId);
        metaData.setFileName(file.getOriginalFilename());
        metaData.setDocId(file.getOriginalFilename() + System.currentTimeMillis());
        LOG.info(metaData.toString());
        return fileService.saveFile(file,metaData);
    }

    @RequestMapping(value = "/{keyword}",method=RequestMethod.GET, produces = "application/json")
    public List<FileVo> findMeta(@PathVariable String keyword){
        LOG.info("Searching by keyword: " + keyword);
        return fileService.searchFileBy(keyword);
    }
}




