package com.ojash.socialmedia.services;

import com.ojash.socialmedia.models.SocialUser;
import com.ojash.socialmedia.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public String deleteUser(Long userId) {
        SocialUser user = socialUserRepository.findById(userId)
                .orElseThrow(RuntimeException::new);
        socialUserRepository.delete(user);
        return "Delete Sucessfull";
    }
}
