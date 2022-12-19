package com.nocode.pojo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Comment {
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;
}
