package com.data.DataReceiver.entity;

import com.data.DataReceiver.util.AppConstant;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "data")
@Builder
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;
    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "time_received")
    private Long timeReceived;

    @Column(name = "time_sent")
    private Long timeSent;

    @Lob
    @Column(name = "file_content", length = AppConstant.MAX_MB * 1024)
    private byte[] content;
}
