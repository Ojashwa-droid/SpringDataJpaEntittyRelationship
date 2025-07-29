package com.ojash.socialmedia.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "groups")
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<SocialUser> users = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SocialUser> getUsers() {
        return users;
    }

    public void setUsers(Set<SocialUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "SocialGroup{" +
                "id=" + id +
                ", users=" + users +
                '}';
    }
}
