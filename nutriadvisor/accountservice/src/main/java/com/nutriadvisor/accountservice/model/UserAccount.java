package com.nutriadvisor.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import hashing.PasswordHash;


import javax.persistence.*;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

@Entity(name = "accounts")
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
public class UserAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ApiModelProperty(notes = "First name of the user account",name="first_name",required=true,value="first name")
    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "password", nullable = true)
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private Role role;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] photo;

    public UserAccount(int id, String firstName, String lastName, String email,String password,Role role,
                byte[] photo) throws NoSuchAlgorithmException {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.photo = photo;

    }

}
