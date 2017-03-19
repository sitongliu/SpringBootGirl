package com.sitong.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by LiuSitong on 2017/3/16.
 */
@Component  //属性得注入需要
@ConfigurationProperties(prefix = "girl")  //前缀是girl得属性
public class GirlProperty {
    private Integer age;
    private String cupSize;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
