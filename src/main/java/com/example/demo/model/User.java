// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "users")
// @Data
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    
//     @Column(unique = true, nullable = false)
//     private String email;
    
//     @Column(nullable = false)
//     private String password;
    
//     private String role = "LEARNER";
    
//     @Column(name = "created_at")
//     private LocalDateTime createdAt;
    
//     @PrePersist
//     public void prePersist() {
//         this.createdAt = LocalDateTime.now();
//     }
// }


package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Column(length = 50)
    private String preferredLearningStyle;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "instructor")
    @JsonIgnore   
    private List<Course> courses;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null) {
            this.role = "LEARNER";
        }
    }
}


