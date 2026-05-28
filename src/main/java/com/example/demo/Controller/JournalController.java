package com.example.demo.Controller;

import com.example.demo.enitity.JournalEntry;
import com.example.demo.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/all")
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @GetMapping("id/{myid}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myid){
        return journalEntryService.findById(myid).orElse(null);
    }

    @DeleteMapping("id/{myid}")
    public boolean deleteJournalEntry(@PathVariable ObjectId myid){
         journalEntryService.deleteById(myid);
         return true;
    }

    @PutMapping("id/{myid}")
    public JournalEntry updateJournalEntry(@PathVariable ObjectId myid, @RequestBody JournalEntry newEntry) {
        JournalEntry journalEntry = journalEntryService.findById(myid).orElse(null);
        if(journalEntry!=null){
            journalEntry.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals(" ")?newEntry.getTitle(): journalEntry.getTitle());
            journalEntry.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals(" ")? newEntry.getContent() : journalEntry.getContent());
        }
        journalEntryService.saveEntry(newEntry);
        return newEntry;
    }


}
