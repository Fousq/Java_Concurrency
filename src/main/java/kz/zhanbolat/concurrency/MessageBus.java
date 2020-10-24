package kz.zhanbolat.concurrency;

import kz.zhanbolat.concurrency.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class MessageBus {
    private List<Post> postList;

    public MessageBus() {
        postList = new ArrayList<>();
    }

    public void add(Post post) {
        postList.add(post);
    }

    public Post get(String topic) throws NoSuchTopicException {
        return postList.stream().filter(post -> post.getTopic().equals(topic))
                .findFirst()
                .orElseThrow(() -> new NoSuchTopicException("No such topic found " + topic));
    }
}
