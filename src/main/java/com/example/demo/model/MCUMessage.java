package com.example.demo.model;

import com.example.demo.deserializer.CustomDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Data
@Table(name = "mcu_message")
public class MCUMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String deviceId;
    @Column(name = "machine_id")
    private String siteId;
    private int count;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date publishedTime;
    @Column(name = "nodemcu_code")
    private String nodeMcuCode;

    @Override
    public String toString() {
        return "MCUMessage{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", siteId='" + siteId + '\'' +
                ", count=" + count +
                ", publishedTime=" + publishedTime +
                ", nodeMcuCode='" + nodeMcuCode + '\'' +
                '}';
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }
}
