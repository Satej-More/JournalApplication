package com.example.demo.enitity;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Document(collection = "journal_entries")
public class JournalEntry {
    @Id
    private ObjectId id;

    private String title;

    private Date date;

    private String content;

}
