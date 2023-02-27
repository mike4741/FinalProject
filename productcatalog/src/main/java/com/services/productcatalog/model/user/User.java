//package com.services.productcatalog.model.user;
//
//
//import jakarta.persistence.*;
//import lombok.*;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.Set;
//
//@Entity
//@Slf4j
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Getter
//@Setter
//@ToString
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    long id;
//    String name;
//    String username;
//    String email;
//    String password;
//
//    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn (name = "user_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
//    private Set<Role> roles ;
//
//}
