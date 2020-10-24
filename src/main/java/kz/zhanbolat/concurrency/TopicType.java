package kz.zhanbolat.concurrency;

public enum TopicType {
    SPORT("Sport"), CUISINE("Cuisine"), BREAKING_NEWS("Breaking news");

    private String name;

    TopicType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
