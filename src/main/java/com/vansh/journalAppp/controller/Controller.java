package com.vansh.journalAppp.controller;

import com.vansh.journalAppp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jourrnal") // use to map the complete class and then check which call is this.
public class Controller { //is used to create REST APIs — meaning it handles HTTP requests and  directly returns data (usually JSON)
    private Map<String, JournalEntry> journalEntryMap = new HashMap<>();

   @GetMapping
   public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntryMap.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){ //request body -- Takes JSON input from client (Postman)// Converts it into JournalEntry object
        journalEntryMap.put(myEntry.getId() ,myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getbyid (@PathVariable String myId){ //PathVariable-- It is a Spring Boot annotation used to extract values from the URL path and pass them into your method.
       return journalEntryMap.get(myId);

    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deletebyID (@PathVariable String myId){
       return journalEntryMap.remove(myId);

    }
    @PutMapping("id/{myId}")
    public JournalEntry updatById(@PathVariable String myId ,@RequestBody JournalEntry myEntry ){
        return journalEntryMap.put("id", myEntry);
    }


}
