package com.javaproject.rest.example.restfulwebservices.user.post;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.javaproject.rest.example.restfulwebservices.exception.PostNotFoundException;
import com.javaproject.rest.example.restfulwebservices.exception.UserNotFoundException;
import com.javaproject.rest.example.restfulwebservices.user.User;
import com.javaproject.rest.example.restfulwebservices.user.UserRepository;

//@RestController
public class PostJPAResource {

	/*@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> getPostsForUser(@PathVariable Integer id) {
		Optional<User> foundUser = userRepository.findById(id);

		if (!foundUser.isPresent()) {
			throw new UserNotFoundException("Id:" + id);
		}
		return foundUser.get().getPost();
	}

	@GetMapping(path = "/jpa/posts/{post_id}")
	public Optional<Post> getPostsByPostId(@PathVariable Integer post_id) {

		Optional<Post> foundPost = postRepository.findById(post_id);

		if (!foundPost.isPresent()) {
			throw new PostNotFoundException("Id:" + post_id);
		}
		return foundPost;
	}

	*//***
	 * create a new post for a given user and return the uri of the new post as
	 * response
	 *//*
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable Integer id, @RequestBody Post post) {
		Optional<User> foundUser = userRepository.findById(id);

		if (!foundUser.isPresent()) {
			throw new UserNotFoundException("Id:" + id);
		}

		User user = foundUser.get();
		post.setUser(user);
		postRepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getPostId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
*/
}
