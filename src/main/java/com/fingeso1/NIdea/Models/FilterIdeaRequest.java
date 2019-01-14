package com.fingeso1.NIdea.Models;

import org.springframework.data.annotation.Id;

public class FilterIdeaRequest {
    private String tag;

    @Id
    private String _id;

    public FilterIdeaRequest(String tag) {
        this.tag = tag;
    }
    
    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
