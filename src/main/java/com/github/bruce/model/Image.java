package com.github.bruce.model;

import lombok.Data;
import lombok.NonNull;

@Data(staticConstructor = "of")
public class Image {
    @NonNull
    private String url;
}
