package multiproceed.common.tool;

import java.sql.Timestamp;

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

    public String getID() {
        return ID;
    }

    public void setID(String val) {
        ID = val;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String val) {
        filename = val;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String val) {
        creator = val;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp val) {
        timestamp = val;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String val) {
        description = val;
    }

}
