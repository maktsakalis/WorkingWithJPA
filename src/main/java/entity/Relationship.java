/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author makis
 */
@Entity
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Student relatedStudent;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Student student;

    @Enumerated(EnumType.STRING)
    @Column(name = "relationshipType")
    private RelationshipType relationshipType;

    public Relationship() {
    }

    public Relationship(Student relatedStudent, Student student, RelationshipType relationshipType) {
        this.relatedStudent = relatedStudent;
        this.student = student;
        this.relationshipType = relationshipType;
    }

    public Student getRelatedStudent() {
        return relatedStudent;
    }

    public void setRelatedStudent(Student relatedStudent) {
        this.relatedStudent = relatedStudent;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(RelationshipType relationshipType) {
        this.relationshipType = relationshipType;
    }

    @Override
    public String toString() {
        return "Relationship{" + "id=" + id + ", relationshipType=" + relationshipType + '}';
    }


}
