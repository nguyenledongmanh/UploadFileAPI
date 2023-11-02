package com.data.DataReceiver.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IDataService {
    String uploadData(MultipartFile file, String fileName, Long timeSent) throws
            IOException;
}
