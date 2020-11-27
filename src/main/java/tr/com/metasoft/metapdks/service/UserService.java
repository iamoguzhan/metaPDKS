package tr.com.metasoft.metapdks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.metasoft.metapdks.model.User;
import tr.com.metasoft.metapdks.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getById(String id){
        return userRepository.findById(id).orElse(null);
    }

    public void delete(User user){
        userRepository.delete(user);
    }

    public User findUserByDeviceId(String device_id){
        return userRepository.findUserByDeviceId(device_id);
    }

//    public User findUserByUserName(String userName) {
//        return userRepository.findByUsername(userName);
//    }

}
