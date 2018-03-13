package pl.szczerbiak.kwejk2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mem") // good practice
public class Mem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String url;
    @OneToOne
    private Category category;
    @OneToMany(
            mappedBy = "mem",
            cascade = CascadeType.ALL,
            orphanRemoval = true // removes orphans (comments without their mem(s))
    )
    private List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

    // Obligatory method in bidirectional @OneToMany
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setMem(this);
    }

    // Obligatory method in bidirectional @OneToMany
    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setMem(null);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
