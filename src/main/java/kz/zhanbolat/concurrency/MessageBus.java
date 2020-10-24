package kz.zhanbolat.concurrency;

import kz.zhanbolat.concurrency.entity.Post;

import java.util.LinkedList;
import java.util.Queue;

public class MessageBus {
    private Queue<Post> postQueue;

    public MessageBus() {
        postQueue = new LinkedList<>();
    }

    public void add(Post post) {
        postQueue.add(post);
    }

    public Post get(String topic) throws NoSuchTopicException {
        Post foundPost = postQueue.stream().filter(post -> post.getTopic().equals(topic))
                .findFirst()
                .orElseThrow(() -> new NoSuchTopicException("No such topic found " + topic));
        postQueue.remove(foundPost);
        return foundPost;
    }
}
