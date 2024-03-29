package com.sdCode.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
private int id;
    @Column(name = "comment")
private String comment;



    public review(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public review(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
}
