package com.diplomado.users.domain.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_detail")
public class UserDetail {
    @Id
    @SequenceGenerator(name = "user_detail_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_detail_sequence")
    private Long id;
    private String first_name;
    private String last_name;
    private Integer age;
    private LocalDate birth_day;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public UserDetail(String first_name, String last_name, Integer age, LocalDate birth_day) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.birth_day = birth_day;
    }

    public UserDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(LocalDate birth_day) {
        this.birth_day = birth_day;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User users) {
        this.user = users;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", birth_day=" + birth_day +
                ", users=" + user +
                '}';
    }
}
