package com.example.demo.services;

import com.example.demo.model.NodeMcu;
import com.example.demo.repository.NodeMcuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeMcuServiceImpl implements NodeMcuService{

    Logger logger = LoggerFactory.getLogger(NodeMcuServiceImpl.class);

    @Autowired
    NodeMcuRepository nodeMcuRepository;


    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<String> getNodeMcu() {
        List<String> nodemcu = jdbcTemplate.query("select name from nodemcu", (rs, rowNum) -> rs.getString("name"));
        return nodemcu;
    }

    @Override
    public NodeMcu getNodeMcuByCode(String code) {
//        logger.info("getting nodemcu from database");
//        NodeMcu nodeMcu = jdbcTemplate.queryForObject("select * from nodemcu where code = ?", new Object[]{code}, (rs, rowNum) -> new NodeMcu(rs.getString("code"), rs.getString("name")));
//        logger.info("NodeMcu fetched");
//        return nodeMcu;
        return null;
    }

    @Override
    public NodeMcu addNodeMcu(NodeMcu nodeMcu) {
        logger.info("savinc nodemcu to database");
        nodeMcuRepository.save(nodeMcu);
        logger.info("NodeMcu added");
        return nodeMcu;
    }
}
