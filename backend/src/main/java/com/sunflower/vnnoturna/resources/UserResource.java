package com.sunflower.vnnoturna.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sunflower.vnnoturna.dto.UserDTO;
import com.sunflower.vnnoturna.entities.User;
import com.sunflower.vnnoturna.services.UserService;

@RestController
@RequestMapping(value = "vnnoturna/api/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "newuser")
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
		User obj = new User();
		BeanUtils.copyProperties(objDto, obj);
		userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable long id) {
		UserDTO obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<UserDTO> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@DeleteMapping(value = "/deleteuser/{id}")
	public ResponseEntity<Void> delete (@PathVariable long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/updateuser/{id}")
	public ResponseEntity<Void> update(@PathVariable long id, @RequestBody User obj){
		obj = userService.update(id, obj);
		return ResponseEntity.ok().build();
	}
	
}
