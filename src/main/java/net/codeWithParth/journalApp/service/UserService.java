package net.codeWithParth.journalApp.service;

import net.codeWithParth.journalApp.entity.JournalEntry;
import net.codeWithParth.journalApp.entity.Users;
import net.codeWithParth.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void saveEntry(Users user)
    {
       userRepository.save(user);
    }
    public List<Users> getALl(){
        return userRepository.findAll();
    }
    public Optional<Users> findById(ObjectId id)
    {
        return userRepository.findById(id);
    }
    public void deleteById(ObjectId id)
    {
        userRepository.deleteById(id);
    }
    public Users findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}


//controller--->Service--->Repository