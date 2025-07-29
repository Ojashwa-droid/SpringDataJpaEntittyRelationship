package com.ojash.socialmedia.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private SocialProfile socialProfile;

    @OneToMany(mappedBy = "socialUser", fetch = FetchType.EAGER)
    private List<Post> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"), // Foreign key for the owning side of this bidirectional many-to-many relationship.
            inverseJoinColumns = @JoinColumn(name = "group_id")) // Foreign key to the inverse (non-owning side of the relationship)
    @EqualsAndHashCode.Exclude
    private Set<SocialGroup> groups = new HashSet<>();

    public Long getId() {
        return id;
    }

    public SocialProfile getSocialProfile() {
        return socialProfile;
    }

    public void setSocialProfile(SocialProfile socialProfile) {
        socialProfile.setUser(this);
        this.socialProfile = socialProfile;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Set<SocialGroup> getGroups() {
        return groups;
    }

    public void setGroups(Set<SocialGroup> groups) {
        this.groups = groups;
    }

}



