package com.diplomado.users.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "users_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
    private Long id;
    private String username;
    private String password;
    private String email;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime created_id;

    public User(String username, String password, String email, LocalDateTime created_id) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.created_id = created_id;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreated_id() {
        return created_id;
    }

    public void setCreated_id(LocalDateTime created_id) {
        this.created_id = created_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", created_id=" + created_id +
                '}';
    }
}
