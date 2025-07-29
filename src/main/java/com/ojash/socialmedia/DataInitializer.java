package com.ojash.socialmedia;

import com.ojash.socialmedia.models.Post;
import com.ojash.socialmedia.models.SocialGroup;
import com.ojash.socialmedia.models.SocialProfile;
import com.ojash.socialmedia.models.SocialUser;
import com.ojash.socialmedia.repositories.PostRepository;
import com.ojash.socialmedia.repositories.SocialGroupRepository;
import com.ojash.socialmedia.repositories.SocialProfileRepository;
import com.ojash.socialmedia.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class DataInitializer {

    @Autowired
    private SocialUserRepository userRepository;

    @Autowired
    private SocialProfileRepository socialProfileRepository;

    @Autowired
    private SocialGroupRepository groupRepository;

    @Autowired
    private PostRepository postRepository;

    @Bean
    public CommandLineRunner mycommandLineRunner(){
        return (args -> {

            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            // Saving the users
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            // Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            // Add the users to the groups
            group1.getUsers().add(user1);
            group1.getUsers().add(user2);

            group2.getUsers().add(user2);
            group2.getUsers().add(user3);

            // Associate the groups to the users as well (owning side -> user, non-owning side -> group)
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);


           // Save the groups to the database
            groupRepository.save(group1);
            groupRepository.save(group2);

            // Save the users back to the repository to propagate the changes properly
            userRepository.saveAll(List.of(user1, user2, user3));

            // Create some posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            // Associate posts with users
            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            // Saving the post in the database
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            // Create some social profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Associate profiles with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            // Saving the profiles with users in the database
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);

            // Fetching types
            System.out.println();
            System.out.println("FETCH TYPES");
            Optional<SocialUser> byId = userRepository.findById(1L);
            System.out.println(byId.get().getPosts());
        });
    }
}
