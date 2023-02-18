package com.forum.forum.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "story")
public class Story {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long StoryID;

    Long userID;

}
