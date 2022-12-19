package com.nocode.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Post {
    public int userId;
    public int id;
    public String title;
    public boolean completed;
}
