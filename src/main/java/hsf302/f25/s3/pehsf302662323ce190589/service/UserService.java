package hsf302.f25.s3.pehsf302662323ce190589.service;

import hsf302.f25.s3.pehsf302662323ce190589.entity.User;
import hsf302.f25.s3.pehsf302662323ce190589.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user!=null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean isAdminOrStaff(User user) {
        return user != null && (user.getRole().equals("Admin") || user.getRole().equals("Staff"));
    }
}
