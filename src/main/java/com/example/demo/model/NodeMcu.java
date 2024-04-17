package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "nodemcu")
public class NodeMcu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private String status;
//    @OneToMany(mappedBy = "nodeMcu", cascade = CascadeType.ALL)
//    private List<MCUMessage> messages;
    private Date installationDate;
    private Date receivedTime;
}
