package com.guneet.User.service;

import java.util.List;

import com.guneet.User.shared.UserDto;

public interface UserService {
	public UserDto createUser(UserDto userDetails);
	public List<UserDto> findAllUsers();
}
