package org.demo.prop;

public class Greeting {
    private final long id;
    private final String content;
    private final String restHost;
    private final String restUrl;
    private final String mysqlHost;
    private final String redisHost;

    public Greeting(long id, String content, String restHost, String restUrl, String mysqlHost, String redisHost) {
        this.id = id;
        this.content = content;
        this.restHost = restHost;
        this.restUrl = restUrl;
        this.mysqlHost = mysqlHost;
        this.redisHost = redisHost;
    }

    public long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getRestHost() {
        return restHost;
    }
    public String getRestUrl() {
        return restUrl;
    }
    public String getMysqlHost() {
        return mysqlHost;
    }
    public String getRedisHost() {
        return redisHost;
    }
}
