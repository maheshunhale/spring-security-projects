package com.mahesh.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahesh.springcloud.model.Role;

public interface Rolerepo extends JpaRepository<Role, Long> {

}
