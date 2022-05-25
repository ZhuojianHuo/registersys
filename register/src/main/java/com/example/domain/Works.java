package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Date;


@Data
public class Works {
    private String code;
    private Integer id;
    private String title;
    private String press;
    private String author;
    private String status = "审核中";

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    private Date pressDate;

//    @Override
//    public String toString() {
//        return "Works{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", press='" + press + '\'' +
//                ", size='" + size + '\'' +
//                ", date=" + date +
//                '}';
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getPress() {
//        return press;
//    }
//
//    public void setPress(String press) {
//        this.press = press;
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    public void setSize(String size) {
//        this.size = size;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
