package kz.zhanbolat.concurrency.entity;

import java.util.Objects;

public class Post {
    private String topic;
    private String msg;

    public Post(String topic, String msg) {
        this.topic = topic;
        this.msg = msg;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(topic, post.topic) &&
                Objects.equals(msg, post.msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, msg);
    }

    @Override
    public String toString() {
        return "Post{" +
                "topic='" + topic + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
