package com.guneet.User.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guneet.User.data.UserEntity;
import com.guneet.User.data.UserRepository;
import com.guneet.User.shared.UserDto;

@Service
public class UserServiceImpl implements UserService{

	UserRepository userRepository;
	public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDto createUser(UserDto userDetails) {
		log.info("inside "+this.getClass() + " service method : " + "createUser" + " is called");
		userDetails.setUserId(UUID.randomUUID().toString());
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity =  modelMapper.map(userDetails, UserEntity.class);
		userEntity.setEncryptedPassword("test");
		
		userRepository.save(userEntity);
		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
		return returnValue;
	}

	@Override
	public List<UserDto> findAllUsers() {
		log.info("inside "+this.getClass() + " service method : " + "findAllUsers" + " is called");
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserEntity> userEntities = userRepository.findAll();
		List<UserDto> returnValue = userEntities
				.stream()
				.map(users->modelMapper.map(users, UserDto.class))
				.collect(Collectors.toList());
				
		return returnValue;
	}

}
