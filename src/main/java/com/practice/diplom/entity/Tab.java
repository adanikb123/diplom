package com.practice.diplom.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tabs")
public class Tab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instrument_name", nullable = false, length = 50)
    private String instrumentName;

    @Column(name = "instrument_name", nullable = false, length = 50)
    private String instrumentName;
  
    @Column(name = "url", nullable = false, length = 70)
    private String url;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private Song song;
}
