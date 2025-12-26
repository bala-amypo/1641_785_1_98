// package com.example.demo.model;

// import java.time.LocalDateTime;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.Table;
// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Entity
// @Table(name = "users")
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     @NotBlank
//     @Size(max = 100)
//     private String fullName;
//     @Email
//     @NotBlank
//     @Column(unique = true)
//     private String email;
//     @NotBlank
//     @Size(min = 8)
//     private String password;
//     @NotBlank
//     private String role;
//     @Size(max = 50)
//     private String preferredLearningStyle;
//     private LocalDateTime createdAt;

//     @PrePersist
//     public void Oncreate(){
//         LocalDateTime n = LocalDateTime.now();
//         if(this.createdAt==null){
//             this.createdAt=n;
//         }
//     }
// }

package com.example.demo.model;  // ← CHANGED

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private String role;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
