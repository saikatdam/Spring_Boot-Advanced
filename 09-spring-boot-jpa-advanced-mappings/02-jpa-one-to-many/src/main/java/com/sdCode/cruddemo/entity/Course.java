package com.sdCode.cruddemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    // define our fields

    //define constructors

    //define getters setters

    //define toString

    //annotate fields
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "title")
    private String title;
@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.MERGE})
@JoinColumn(name = "instructor_id")
    private Instructor instructor;
@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JoinColumn(name = "course_id")
private List<review> reviews;

    public List<review> getReviews() {
        return reviews;
    }

    public void setReviews(List<review> reviews) {
        this.reviews = reviews;
    }

    public Course(){

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    //add a convenience method

    public void addReview(review theReview) {
    if (reviews==null){
        reviews=new ArrayList<>();
    }
    reviews.add(theReview);
    }

    public Course(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
