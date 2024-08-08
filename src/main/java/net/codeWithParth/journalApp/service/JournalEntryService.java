package net.codeWithParth.journalApp.service;

import net.codeWithParth.journalApp.entity.JournalEntry;
import net.codeWithParth.journalApp.entity.Users;
import net.codeWithParth.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private  UserService userService;
    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName)
    {
        try{
            Users user = userService.findByUserName(userName);
            JournalEntry savedJournalEntryInDb = journalEntryRepository.save(journalEntry);
            user.getJournalEntryList().add(savedJournalEntryInDb);
            //user.setUserName(null);
            userService.saveEntry(user);
        }catch (Exception e)
        {
            System.out.println(e);
            throw new RuntimeException("An Error has occur");
        }

    }
    public void saveEntry(JournalEntry journalEntry)
    {
        journalEntryRepository.save(journalEntry);
    }
    public List<JournalEntry> getALl(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id)
    {
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id, String userName)
    {
        Users users = userService.findByUserName(userName);
        users.getJournalEntryList().removeIf(x->x.equals(id));
        userService.saveEntry(users);
        journalEntryRepository.deleteById(id);
    }
}


//controller--->Service--->Repository