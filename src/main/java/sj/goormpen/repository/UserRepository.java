package sj.goormpen.repository;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class UserRepository {
    private final Set<String> users = new HashSet<>();

    public Set<String> getUsers() {
        return new HashSet<>(users);
    }

    public void addUser(String username) {
        users.add(username);
    }

    public void removeUser(String username) {
        users.remove(username);
    }
}
