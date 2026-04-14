package com.vansh.journalAppp.service;

import com.vansh.journalAppp.entity.JournalEntry;
import com.vansh.journalAppp.repository.JournalEnteryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {

    @Autowired
    private JournalEnteryRepo journalRepo;

    public void saveEntry(JournalEntry jounalEntry){
        journalRepo.save(jounalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalRepo.findAll();
    }

    public Optional<JournalEntry> idSeDhundo(ObjectId id){
        return journalRepo.findById(id);
    }

    public void idKoDelete(ObjectId id){
        journalRepo.deleteById(id);
    }

}
