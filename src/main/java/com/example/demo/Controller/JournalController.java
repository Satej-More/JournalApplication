package com.example.demo.Controller;

import com.example.demo.enitity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
public class JournalController {

    private Map<Long,JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/all")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("id/{myid}")
    public JournalEntry getJournalEntryById(@PathVariable Long myid){
        return journalEntries.get(myid);
    }

    @DeleteMapping("id/{myid}")
    public JournalEntry deleteJournalEntry(@PathVariable Long myid){
        return journalEntries.remove(myid);
    }

    @PutMapping("id/{myid}")
    public JournalEntry updateJournalEntry(@PathVariable Long myid, @RequestBody JournalEntry myEntry) {
        return journalEntries.put(myid, myEntry);
    }


}
