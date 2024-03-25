package com.practice.diplom.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "author",nullable = false,length = 50)
    private String author;
    @Column(name = "name",nullable = false,length = 50)
    private String name;
    @OneToMany(mappedBy = "song",cascade = CascadeType.REMOVE)
    private List<Tab> tabs ;

}
