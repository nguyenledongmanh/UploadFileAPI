package com.data.DataReceiver.controller;

import com.data.DataReceiver.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private IDataService iDataService;

    @PostMapping("")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file,
                                             @RequestParam("fileName") String fileName,
                                             @RequestParam("timeSent") Long timeSent) throws
            IOException {
        String uploadStatus = iDataService.uploadData(file, fileName, timeSent);
        return ResponseEntity.ok(uploadStatus);
    }
}
