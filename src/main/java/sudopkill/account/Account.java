package sudopkill.account;

/**
 * Created by tanzeelrana on 3/5/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import sudopkill.AuthProvider.AuthProvider;
import sudopkill.page.Page;
import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@Entity
@Table(name = "ACCOUNT")
@Inheritance
public class Account implements java.io.Serializable {

    @Id
    private String id;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;
    @Column(nullable = false)
    private String authProvider;

    private String about = "";
    private String name = "";
    private String profilePicture = "http://ec2-52-11-47-52.us-west-2.compute.amazonaws.com/moodle/theme/image.php/clean/core/1475717594/u/f1";
    private String role = "ROLE_USER";
    private Instant created = Instant.now();
    private Date created_at = new Date((Calendar.getInstance().getTime()).getTime());

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Page> myPages = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Page> myLikes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Account> myFollowers = new HashSet<>();

    public Account() {}

    public Account(String email, String password, String role, String authProvider) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.authProvider = authProvider;

        if(authProvider == AuthProvider.LOCAL.toString()){
            this.id = email;
            this.name = email;
        }
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Instant getCreated() {
        return created;
    }

    public String getAuthProvider() {
        return authProvider;
    }

    @OneToMany(mappedBy = "ACCOUNT", cascade = CascadeType.ALL)
    public Set<Page> getMyPages() {
        return myPages;
    }

    @OneToMany(mappedBy = "ACCOUNT", cascade = CascadeType.ALL)
    public Set<Page> getMyLikes() {
        return myLikes;
    }

    @OneToMany(mappedBy = "ACCOUNT")
    public Set<Account> getMyFollowers() {
        return myFollowers;
    }

    public void setAuthProvider(String authProvider) {
        this.authProvider = authProvider;
    }

    public void setMyPages(Set<Page> myPages) {
        this.myPages = myPages;
    }

    public void setMyLikes(Set<Page> myLikes) {
        this.myLikes = myLikes;
    }

    public void setMyFollowers(Set<Account> myFollowers) {
        this.myFollowers = myFollowers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public Set<Account> getMyFollowing(){
        Set<Account> retVal = new HashSet<Account>();
        return retVal;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void addMyPages(Page page){
        this.myPages.add(page);
    }

    public void addMyLikes(Page page){
        this.myLikes.add(page);
    }

    public void addMyFollower(Account account){
        this.myFollowers.add(account);
    }

    public void removeMyPages(Page page){
        this.myPages.remove(page);
    }

    public void removeMyLikes(Page page){
        this.myLikes.remove(page);
    }

    public void removeMyFollower(Account account){
        this.myFollowers.remove(account);
    }

}