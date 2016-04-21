package com.kaishengit.mapper;

import com.kaishengit.pojo.Topic;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TopicMapper {

    Topic findById(Integer id);

    Topic findByIdNew(Integer id);

    List<Topic> findByParam(Map<String,Object> param);

    List<Topic> findByNodeIds(List<Integer> nodeIds);


}
