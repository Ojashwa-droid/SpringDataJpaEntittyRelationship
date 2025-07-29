package com.ojash.socialmedia.repositories;

import com.ojash.socialmedia.models.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialGroupRepository  extends JpaRepository<SocialGroup, Long> {
}
