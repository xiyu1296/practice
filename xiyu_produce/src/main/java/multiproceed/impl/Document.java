package multiproceed.impl;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Document {
    private String ID;
    private String filename;
    private String creator;
    private Timestamp timestamp;
    private String description;

    public Document(String ID, String filename, String creator, Timestamp timestamp, String description) {
        this.ID = ID;
        this.filename = filename;
        this.creator = creator;
        this.timestamp = timestamp;
        this.description = description;
    }

}
