package com.example.tutorial.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository//tells this is the interface to use for our db management functions
public interface UserRepository extends JpaRepository<User, Long> {
    //JpaRepository<User, Long>: links the interface to our db table
    //we tell it to look aat our USER table and we tell it that the value fo our id field is LONG

}
