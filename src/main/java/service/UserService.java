package service;

import org.springframework.beans.factory.annotation.Autowired;
import repository.UserRepository;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<Void> userList();

}
