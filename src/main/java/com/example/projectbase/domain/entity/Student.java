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
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_code", nullable = false, updatable = false, unique = true)
    private String studentCode;

    @Nationalized
    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "total_credits_registered", nullable = false)
    private double totalCreditsRegistered;

    @Column(name = "tuition_fees", nullable = false)
    private double tuitionFees;

    // Link to table Registration
    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "subscriber")
    @JsonIgnore
    private Set<Registration> registers = new HashSet<>();
}
