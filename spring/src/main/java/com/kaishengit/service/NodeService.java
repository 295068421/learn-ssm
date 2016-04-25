package com.kaishengit.service;

import com.kaishengit.mapper.NodeMapper;
import com.kaishengit.pojo.Node;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Transactional
public class NodeService {

    @Inject
    private NodeMapper nodeMapper;

    public void save(Node node) {
        nodeMapper.save(node);
    }

    @Transactional(readOnly = true)
    public Node findById(Integer id) {
        return nodeMapper.findById(id);
    }


}
