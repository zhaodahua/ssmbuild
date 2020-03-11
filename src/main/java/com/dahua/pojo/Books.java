package com.dahua.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//实体类

@Data
@NoArgsConstructor
@AllArgsConstructor
public class  Books {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
