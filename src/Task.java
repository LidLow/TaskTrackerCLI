import java.time.LocalDateTime;

public class Task {
    private int id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task (int id, String description) {
        this.id = id;
        this.description = description.trim();
        this.status = "Todo";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription.trim();
        setUpdatedAt();
    }

    public void setStatusInProgress () {
        this.status = "In-progress";
        setUpdatedAt();
    }

    public void setStatusDone () {
        this.status = "Done";
        setUpdatedAt();
    }

    public void setUpdatedAt () {
        this.updatedAt = LocalDateTime.now();
    }

    public String getStatus () {
        return status;
    }

    public int getID () {
        return id;
    }

    public String getDescription() {
        return description;
    }
}