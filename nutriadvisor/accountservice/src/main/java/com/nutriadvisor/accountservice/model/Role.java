package com.nutriadvisor.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "roles")
@Inheritance
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "role_name", nullable = true)
    private String roleName;

    @OneToMany(mappedBy="role")
    private List<UserAccount> userAccounts;

    public Role(int id, String roleName){
        this.id=id;
        this.roleName=roleName;
    }



}

