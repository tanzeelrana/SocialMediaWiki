package sudopkill.page;

import sudopkill.account.Account;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;



/*
 * Created by markpineda on 3/5/2017.
 *
 * Page in context of user created pages
 *
 */

@Entity
@Table(name = "PAGE")
public class Page {

    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String content;
    private Account author;
    private Instant created;

    @OneToOne
    private Page parent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private Set<Page> childNodes;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Account> likes;

    public Page(){}

    public Page(String title, String content, Account author, Page parent){
        this.title = title;
        this.content = content;
        this.author = author;
        this.parent = parent;
        this.created = Instant.now();
        this.childNodes = new HashSet<>();
        this.likes = new HashSet<>();
    }

    public long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_id")
    public Account getAuthor() {
        return author;
    }

    public Instant getCreated() {
        return created;
    }

    public Page getParent() {
        return parent;
    }

    public Set<Page> getChildNodes() {
        return childNodes;
    }

    public Set<Account> getLikes() {
        return likes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public void setParent(Page parent) {
        this.parent = parent;
    }

    public void setChildNodes(Set<Page> childNodes) {
        this.childNodes = childNodes;
    }

    public void setLikes(Set<Account> likes) {
        this.likes = likes;
    }

    public void addChildNode (Page page) {
        this.childNodes.add(page);
    }

}

