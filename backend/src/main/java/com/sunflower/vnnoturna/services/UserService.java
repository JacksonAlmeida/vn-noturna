package com.sunflower.vnnoturna.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunflower.vnnoturna.dto.UserDTO;
import com.sunflower.vnnoturna.entities.User;
import com.sunflower.vnnoturna.repository.UserRepository;
import com.sunflower.vnnoturna.services.exceptions.DatabaseException;
import com.sunflower.vnnoturna.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;

	public void insert(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public UserDTO findById(long id) {
		Optional<User> obj = userRepository.findById(id);
		if (obj.isPresent()) {
			return obj.stream().map(x -> new UserDTO(x)).findAny().get();
		} else {
			Optional<UserDTO> dto = Optional.empty();
			return dto.orElseThrow(() -> new ResourceNotFoundException(id));
		}
	}

	public List<UserDTO> findAll() {
		List<User> list = userRepository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}

	public void delete(long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(long id, User obj) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}

	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
	}

}