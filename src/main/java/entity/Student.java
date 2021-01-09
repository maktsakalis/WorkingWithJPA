package entity;

import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class Student {

    //for Hibernate 4.3.x Users
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // for Hibernate 5.x Users
    // if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
    // for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
    /*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
     */
    @Column(name = "enrollment_id", nullable = false)
    private String enrollmentId;

    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "guide_id")
    private Guide guide;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    @MapKey(name = "relatedStudent")
    Map<Student, Relationship> relatedStudentRelationships;

    @OneToMany(mappedBy = "relatedStudent", cascade = CascadeType.PERSIST)
    @MapKey(name = "student")
    Map<Student, Relationship> studentRelationships;

//    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
//    List<Relationship> relatedStudentRelationships;
//
//    @OneToMany(mappedBy = "relatedStudent", cascade = CascadeType.PERSIST)
//    List<Relationship> studentRelationships;

    public Student() {
    }

    public Student(String enrollmentId, String name) {
        this.enrollmentId = enrollmentId;
        this.name = name;
    }

    public Student(String enrollmentId, String name, Guide guide) {
        this.enrollmentId = enrollmentId;
        this.name = name;
        this.guide = guide;
    }


    public String getName() {
        return name;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setEnrollmentId(String enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public Map<Student, Relationship> getRelatedStudentRelationships() {
        return relatedStudentRelationships;
    }

    public void setRelatedStudentRelationships(Map<Student, Relationship> relatedStudentRelationships) {
        this.relatedStudentRelationships = relatedStudentRelationships;
    }

    public Map<Student, Relationship> getStudentRelationships() {
        return studentRelationships;
    }

    public void setStudentRelationships(Map<Student, Relationship> studentRelationships) {
        this.studentRelationships = studentRelationships;
    }


//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 89 * hash + Objects.hashCode(this.enrollmentId);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Student other = (Student) obj;
//        if (!Objects.equals(this.enrollmentId, other.enrollmentId)) {
//            return false;
//        }
//        return true;
//    }
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", enrollmentId=" + enrollmentId + ", name=" + name + '}';
    }

}
