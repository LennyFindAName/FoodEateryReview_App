package com.example.foodeateryreview.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Comment {

    private int CommentId;
    private String Content;
    private int CommentStatus;
    private int UserId;
    private String Username;
    private int BlogId;
    private int CommentLike;
    private Date CommentDate;
}
