package com.example.notes.models;

import jakarta.persistence.Entity;

import lombok.*;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class NoteModel {
    @Id
    @GeneratedValue()
    private Long id;

    @Column
    private Long folder = (long) 0;

    @Column(nullable = false)
    private String content;

    @Column
    @CreationTimestamp
    private Date createdAt;


    @Column
    @UpdateTimestamp
    private Date updatedAt;
}
