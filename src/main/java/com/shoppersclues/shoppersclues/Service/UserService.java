package com.shoppersclues.shoppersclues.Service;

import com.shoppersclues.shoppersclues.Entity.User;
import com.shoppersclues.shoppersclues.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User add_user(User user) {
        return userRepository.save(user);
    }

    public Optional<User> get_byId(long id) {
        return userRepository.findById(id);
    }

    public void delete_byId(long id) {
         userRepository.deleteById(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User update_ById(long id, Map<String, Object> updates) {
        // Fetch the entity (managed by Hibernate)
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Apply partial updates
        if (updates.containsKey("name")) {
            user.setName((String) updates.get("name"));
        }
        if (updates.containsKey("email")) {
            user.setEmail((String) updates.get("email"));
        }

        // No need to call userRepository.save() because @Transactional + managed entity = automatic update
        return user;
    }
}
