package com.kaishengit.test;


import com.kaishengit.dao.NodeDao;
import com.kaishengit.pojo.Node;
import com.kaishengit.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SprintTestCase2 {

    @Inject
    private UserService userService;
    @Inject
    private NodeDao nodeDao;

    @Test
    public void testSave() {
        userService.save();
    }

    @Test
    public void testNodeSave() {
        Node node = new Node();
        node.setNodename("Spring3");

        nodeDao.save(node);
    }

    @Test
    public void testNodeUpdate() {
        Node node = nodeDao.findById(14);
        node.setNodename("SpringMVC");

        nodeDao.update(node);
    }

    @Test
    public void testNodeFindById() {
        Node node = nodeDao.findById(1);
        Assert.assertNotNull(node);
    }

    @Test
    public void testNodeFindAll() {
        List<Node> nodes = nodeDao.findAll();
        Assert.assertEquals(nodes.size(),12);
    }


}
