package com.github.bruce.model;

import lombok.Data;

@Data
public class Video {
    private String item_id;
    private String url;
    private String format;
    private Integer size;
    private Integer duration;
    private Integer sn;
    private String title;
}
