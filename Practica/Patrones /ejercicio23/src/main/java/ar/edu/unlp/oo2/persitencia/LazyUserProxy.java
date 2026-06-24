package ar.edu.unlp.oo2.persitencia;

import java.util.List;

public class LazyUserProxy implements PersistableUser {

    private String username;
    private String email;

    private User user;

    public LazyUserProxy(
            String username,
            String email) {

        this.username = username;
        this.email = email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public List<Post> getPosts() {

        if (user == null) {

            user = new User(
                    username,
                    email);

            user.addPosts(
                    new PostRepository()
                            .findPostsByUsername(username));
        }

        return user.getPosts();
    }
}