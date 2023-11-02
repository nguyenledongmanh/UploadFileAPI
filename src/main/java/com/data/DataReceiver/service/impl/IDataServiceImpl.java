package com.data.DataReceiver.service.impl;

import com.data.DataReceiver.entity.Data;
import com.data.DataReceiver.repository.IDataRepository;
import com.data.DataReceiver.service.IDataService;
import com.data.DataReceiver.util.DataUtils;
import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class IDataServiceImpl
        implements IDataService {

    @Autowired
    private IDataRepository iDataRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public String uploadData(MultipartFile file, String fileName, Long timeSent) throws
            IOException {
        iDataRepository.save(Data.builder()
                                 .fileName(fileName)
                                 .fileType(FilenameUtils.getExtension(fileName))
                                 .fileSize(file.getSize())
                                 .timeReceived(new Date().getTime())
                                 .timeSent(timeSent)
                                 .content(DataUtils.compressData(file.getBytes()))
                                 .build());
        return "Upload Successfully";
    }
}
