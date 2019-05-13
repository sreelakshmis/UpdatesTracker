Goal: create a social media application using the REST webservice and Spring boot. The main resources being User and the Posts made by the user. 

Actions:

User:
Retrieve all users -> Get  /users
Retrieve one user by id -> Get /users/{id} 
Create a user -> Post /users
Delete a user -> Delete /users/{id}

Posts:
Retrieve all posts by the user -> Get  /users/{id}/posts
Retrieve one post by the user -> Get /users/{id}/posts/{post_id} 
Create a post -> Post /users/{id}/posts
Delete a post -> Delete /users/{id}/posts/{post_id}

Exception handling
Ability to handle generic exceptions