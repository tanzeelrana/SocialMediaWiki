package sudopkill.page;

        import sudopkill.account.Account;

        import javax.persistence.*;
        import java.time.Instant;
        import java.util.HashSet;
        import java.util.Set;
        import java.time.format.DateTimeFormatter;
        import java.time.format.FormatStyle;
        import java.util.Locale;
        import java.time.ZoneId;




/*
 * Created by markpineda on 3/5/2017.
 *
 * Page in context of user created pages
 *
 */

@Entity
public class Page {

    private long id;
    private String title;
    private String content;
    private Account author;
    private Instant created;
    private Page parent;
    private Set<Page> childNodes;
    private Set<Account> likes;

    public Page(){
        this.created = Instant.now();
        this.childNodes = new HashSet<>();
        this.likes = new HashSet<>();
    }

    public Page(String title, String content, Account author, Page parent){
        this.title = title;
        this.content = content;
        this.author = author;
        this.parent = parent;
        this.created = Instant.now();
        this.childNodes = new HashSet<>();
        this.likes = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "author")
    public Account getAuthor() {
        return author;
    }

    public Instant getCreated() {
        return created;
    }

    @OneToOne
    public Page getParent() {
        return parent;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    public Set<Page> getChildNodes() {
        return childNodes;
    }

    @OneToMany(cascade = CascadeType.ALL)
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

    public void setId(long id) {
        this.id = id;
    }

//    public String getDateAndTime() {
//        DateTimeFormatter formatter =
//                DateTimeFormatter.ofLocalizedDateTime( FormatStyle.SHORT )
//                        .withLocale( Locale.UK )
//                        .withZone( ZoneId.systemDefault() );
//
//        return formatter.format(created);
//    }
//
//    public void setDateAndTime() {
//    }
//
//    public int getNumLikes() {
//        return likes.size();
//    }

//    public void setNumLikes() {
//
//    }

}

