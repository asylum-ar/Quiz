package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity

@Table(name = "AppUser" )

public class AppUser implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "id")

    private Long id;
@Column(unique = true)
    private String username;
//@JsonProperty(access =JsonProperty.Access.WRITE_ONLY)
@Column(name = "password")

    private String password;
@Column(name = "actived")
    private boolean actived;
    @ManyToMany(fetch = FetchType.EAGER)
    @Column(name = "app_user_roles")
    private Collection<AppRole> roles = new ArrayList<>();

    public AppUser() {
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

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }

    public AppUser(String username, String password, boolean actived, Collection<AppRole> roles) {
        this.username = username;
        this.password = password;
        this.actived = actived;
        this.roles = roles;
    }
    


	
}
