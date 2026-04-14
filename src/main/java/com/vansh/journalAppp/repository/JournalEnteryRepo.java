package com.vansh.journalAppp.repository;

import com.vansh.journalAppp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEnteryRepo extends MongoRepository<JournalEntry, ObjectId>{ //it ask 2 parameter what u are finding and its type
}
