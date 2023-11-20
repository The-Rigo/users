package com.diplomado.users.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_rol")
public class UserRol {
    @Id
    @SequenceGenerator(name = "user_rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_rol_sequence")
    private Integer id;
    private Boolean active;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime created_id;
    //many to one
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rol;

    public UserRol(Boolean active, LocalDateTime created_id, User user, Rol rol) {
        this.active = active;
        this.created_id = created_id;
        this.user = user;
        this.rol = rol;
    }

    public UserRol() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreated_id() {
        return created_id;
    }

    public void setCreated_id(LocalDateTime created_id) {
        this.created_id = created_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UserRol{" +
                "id=" + id +
                ", active=" + active +
                ", created_id=" + created_id +
                ", user=" + user +
                ", rol=" + rol +
                '}';
    }
}
