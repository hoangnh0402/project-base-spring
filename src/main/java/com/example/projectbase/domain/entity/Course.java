package com.example.projectbase.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @Column(name = "course_code", nullable = false, updatable = false, unique = true)
    private String courseCode;

    @Nationalized
    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "number_of_theoretical_credits", nullable = false)
    private double numberOfTheoreticalCredits;

    @Column(name = "number_of_practice_credits", nullable = false)
    private double numberOfPracticeCredits;

    @Column(name = "number_of_end_credits", nullable = false)
    private double numberOfEndCredits;

    @Column(name = "number_of_online_credits", nullable = false)
    private double numberOfOnlineCredits;

    @Column(name = "number_of_total_credits", nullable = false)
    private double numberOfTotalCredits;

    @Column(nullable = false)
    private int semester;

    // Link to table Registration
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    @JsonIgnore
    private Set<Registration> registers = new HashSet<>();
}
