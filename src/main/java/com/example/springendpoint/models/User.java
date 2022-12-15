package com.example.springendpoint.models;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "users")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "usersIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersIdSeq")
    private Long id;
    @Column(name = "name")
    @Size(min = 1, max = 50, message = "Size of the name must be more than 1 and less than 50")
    @NotBlank(message = "You can't leave this field blank")
    private String name;
    @Column(name = "email")
    @Size(max = 50, message = "Email size must be less than 50 symbols")
    @NotBlank(message = "You can't leave this field blank")
    @Email(message = "Incorrect email")
    private String email;
    @Column(name = "phone")
    @NotBlank(message = "You can't leave this field blank")
    private String phone;
}
