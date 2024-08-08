package net.codeWithParth.journalApp.repository;

import net.codeWithParth.journalApp.entity.JournalEntry;
import net.codeWithParth.journalApp.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<Users, ObjectId> {
    Users findByUserName(String username);
}
