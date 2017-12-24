package com.springexercises.springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private static List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring","Spring Framework","Spring Framwork Description"),
            new Topic("java","Core Java","Core Java Description"),
            new Topic("javascript","Java Script","Java Script Description")
    ));

    public List<Topic> getallTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        Topic topicinlist = topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        topicinlist.setName(topic.getName());
        topicinlist.setDescription(topic.getDescription());
    }

    public void deleteTopic(String id) {
//        List<Topic> lTopic = new ArrayList<>();
//        for(Topic topic : topics) {
//            if(!topic.getId().equals(id)) {
//                lTopic.add(topic);
//            }
//        }
//        topics=lTopic;

        topics.removeIf(t -> t.getId().equals(id));
    }
}
