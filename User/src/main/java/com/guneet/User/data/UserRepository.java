package com.guneet.User.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>{


	List<UserEntity> findAll();
}
