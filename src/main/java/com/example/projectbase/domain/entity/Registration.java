package com.example.projectbase.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(insertable = false, updatable = false, nullable = false, columnDefinition = "CHAR(36)")
    private String id;

    @Column(nullable = false)
    private boolean isRegistration;

    @Column(name = "class_code", nullable = false)
    private String classCode;

    @Nationalized
    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(nullable = false)
    private String thoiGian;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String note;

    @Column(name = "registration_order", nullable = false)
    private int registrationOrder;

    // Link to table Course
    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code", foreignKey = @ForeignKey(name = "FK_REGISTER_COURSE"))
    private Course course;

    // Link to table Student
    @ManyToOne
    @JoinColumn(name = "student_code", referencedColumnName = "student_code", foreignKey = @ForeignKey(name = "FK_REGISTER_MEMBER"))
    private Student subscriber;
}
