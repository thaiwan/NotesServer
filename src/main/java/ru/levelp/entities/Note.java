package ru.levelp.entities;

import com.google.gson.annotations.Expose;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by Tanya on 06.12.2016.
 */
@Entity("notes")
@javax.persistence.Entity
@Table(name = "notes")
public class Note implements BaseEntity<String> {
    @Id
    @javax.persistence.Id
    @Column(name="id")
    @Expose
    private String id;
    @Column(name="title")
    @Expose
    private String title;
    @Column(name="body")
    @Expose
    private String body;
    @Column(name="created")
    @Expose
    private long created;
    @Column(name="updated")
    @Expose
    private long updated;
    @Column(name="author")
    @Expose
    private String author;
    private List<AccessRight> accessRights;

    public Note() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public void setAccessRights(List<AccessRight> accessRights) {
        this.accessRights = accessRights;
    }

    public String getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public long getCreated() {
        return created;
    }

    public long getUpdated() {
        return updated;
    }

    public List<AccessRight> getAccessRights() {
        return accessRights;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
