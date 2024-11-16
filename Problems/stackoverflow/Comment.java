package Problems.stackoverflow;

import java.util.Date;

public class Comment {
    private int id;
    private String content;
    private User author;
    private Date creationDate;

    public Comment(String content, User author){
        this.id = generateId();
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
    }

    private int generateId(){
        return (int)(System.currentTimeMillis()%Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public User getAuthor() {
        return author;
    }


}
