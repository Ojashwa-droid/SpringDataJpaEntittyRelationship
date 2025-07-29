package com.ojash.socialmedia.repositories;

import com.ojash.socialmedia.models.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialProfileRepository  extends JpaRepository<SocialProfile, Long> {
}
