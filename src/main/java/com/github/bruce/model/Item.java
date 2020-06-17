package com.github.bruce.model;

import lombok.Data;

import java.util.List;

@Data
public class Item {
    private Integer item_type = 1001;
    private String item_id;
    private String url;
    private String title;
    private String source;
    private String publish_time;
    private String manual_category = "4";
    private List<Video> videos;
    private List<Image> images;
}
