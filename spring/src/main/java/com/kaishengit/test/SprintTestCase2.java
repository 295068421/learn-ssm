package com.kaishengit.test;



import com.kaishengit.pojo.Node;
import com.kaishengit.service.NodeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SprintTestCase2 {


    @Inject
    private NodeService nodeService;

    @Test
    public void testSave() {
        Node node = new Node();
        node.setNodename("Spring+MyBatis");

        nodeService.save(node);
    }

    @Test
    public void testFindById() {
        Node node = nodeService.findById(25);
        Assert.assertNotNull(node);
    }


}
