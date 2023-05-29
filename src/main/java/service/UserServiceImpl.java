package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<Void> userList() {
        List<Void> userList = userRepository.userList();
        return userList;
    }
}
