package com.vansh.journalAppp.controller;

import com.vansh.journalAppp.entity.JournalEntry;
import com.vansh.journalAppp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal") //It defines a base URL (common path) for all APIs inside this controller.
//so their is no need to write end point in each http method
public class JournalControllerv2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) { //requestbody -- Convert incoming JSON data (HTTP request body) into a Java object
      try {
          journalEntryService.saveEntry(myEntry);
          return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
      }
      catch (Exception e){
          return new ResponseEntity<>(myEntry, HttpStatus.BAD_REQUEST);
      }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getbyid (@PathVariable ObjectId myId){ //PathVariable-- used to extract values from the URL path and pass them into your method.
        Optional<JournalEntry> journalEntry = journalEntryService.idSeDhundo(myId);
        if (journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK); // we are  returning response entity so the type of method should also be reponseEntity and is expecting the type their we put the type which is journalEntry.
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping
    public ResponseEntity<?> deletebyId(@PathVariable ObjectId myId){
        journalEntryService.idKoDelete(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping
    public JournalEntry update(@PathVariable ObjectId myId , @RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return myEntry;


    }




}

