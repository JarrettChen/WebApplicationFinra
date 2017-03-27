package net.spring.FileInfo;

import java.util.Date;

public class FileVo {
    private Long fileId;
    private String userId;
    private Date uploadTime;
    private String fileName;
    private String docId;

    public FileVo() {}

    public FileVo(Long fileId, String userId, Date uploadTime, String fileName, String docId) {
        this.fileId = fileId;
        this.userId = userId;
        this.uploadTime = uploadTime;
        this.fileName = fileName;
        this.docId = docId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "fileId='" + fileId + '\'' +
                ", userId='" + userId + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
