package service;

import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;

import java.util.Map;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void userList(Long id) {
        userRepository.userList();
    };

}
