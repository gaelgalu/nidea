package com.fingeso1.NIdea.Models;
import org.springframework.data.annotation.Id;
public class IdeaRequest {
    private String content;
    private String tags;
    private String author;
    @Id
    private String _id;
    public IdeaRequest(String content, String tags, String author) {
        this.content = content;
        this.tags = tags;
        this.author = author;
    }

    public String get_id() {
        return _id;
    }

    public String getContent() {
        return content;
    }

    public String getTags() {
        return tags;
    }

    public String getAuthor() {
        return author;
    }
}
