package com.example.springendpoint.repository;

import com.example.springendpoint.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.lang.NonNull;

import javax.persistence.QueryHint;


import static org.hibernate.jpa.HibernateHints.HINT_CACHEABLE;

public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @NonNull
    @QueryHints(@QueryHint(name = HINT_CACHEABLE, value = "true"))
    Page<User> findAll(@NonNull Pageable pageable);
}
