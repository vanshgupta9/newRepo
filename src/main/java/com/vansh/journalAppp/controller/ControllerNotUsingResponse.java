package com.vansh.journalAppp.controller;

import com.vansh.journalAppp.entity.JournalEntry;
import com.vansh.journalAppp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ControllerNotUsingResponse {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) { //requestbody -- Convert incoming JSON data (HTTP request body) into a Java object
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getbyid (@PathVariable ObjectId myId){ //PathVariable-- used to extract values from the URL path and pass them into your method.
        return journalEntryService.idSeDhundo(myId).orElse(null) ;
    }

    @DeleteMapping
    public boolean deletebyId(@PathVariable ObjectId myId){
        journalEntryService.idKoDelete(myId);
        return true;

    }

}
