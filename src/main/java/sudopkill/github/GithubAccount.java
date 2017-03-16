package sudopkill.github;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import sudopkill.AuthProvider.AuthProvider;
import sudopkill.account.Account;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.LinkedHashMap;

/**
 * Created by tanzeelrana on 3/7/2017.
 */

@Entity
public class GithubAccount extends Account {

    private int github_id;
    private String login;
    private String avatar_url;
    private String gravatar_id;
    @Column(unique = true)
    private String url;
    @Column(unique = true)
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private Boolean site_admin;
    private String company;
    private String blog;
    private String location;
    private Boolean hireable;
    private String bio;
    private int public_repos;
    private int public_gists;
    private int followers;
    private int following;
//    private String created_at;
//    private String updated_at;

    private String remoteAddress;
    private String sessionId;
    private String tokenValue;
    private String tokenType;

    public GithubAccount() {}

    public GithubAccount(LinkedHashMap dataMap, OAuth2Authentication auth) {

        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)auth.getDetails();

        this.remoteAddress = details.getRemoteAddress();
        this.sessionId = details.getSessionId();
        this.tokenValue = details.getTokenValue();
        this.tokenType = details.getTokenType();

        this.setPassword("");
        this.setRole("ROLE_USER");
        this.setAuthProvider(AuthProvider.GITHUB.toString());
        this.setId( auth.getName() );
        this.setName((String) dataMap.get("name"));
        this.setEmail((String) dataMap.get("email"));
        this.setAbout((String) dataMap.get("bio"));
        this.setProfilePicture((String) dataMap.get("avatar_url"));


        this.github_id = (Integer) dataMap.get("id");
        this.login = (String) dataMap.get("login");

        this.gravatar_id = (String) dataMap.get("gravatar_id");
        this.url = (String) dataMap.get("url");
        this.html_url = (String) dataMap.get("html_url");
        this.followers_url = (String) dataMap.get("followers_url");
        this.following_url = (String) dataMap.get("following_url");
        this.gists_url = (String) dataMap.get("gists_url");
        this.starred_url = (String) dataMap.get("starred_url");
        this.subscriptions_url = (String) dataMap.get("subscriptions_url");
        this.organizations_url = (String) dataMap.get("organizations_url");
        this.repos_url = (String) dataMap.get("repos_url");
        this.events_url = (String) dataMap.get("events_url");
        this.received_events_url = (String) dataMap.get("received_events_url");
        this.type = (String) dataMap.get("type");
        this.site_admin = (Boolean) dataMap.get("site_admin");
        this.avatar_url = (String) dataMap.get("avatar_url");
        this.company = (String) dataMap.get("company");
        this.blog = (String) dataMap.get("blog");
        this.location = (String) dataMap.get("location");
        this.hireable = (Boolean) dataMap.get("hireable");
        this.bio = (String) dataMap.get("bio");
        this.public_repos = (Integer) dataMap.get("public_repos");
        this.public_gists = (Integer) dataMap.get("public_gists");
        this.followers = (Integer) dataMap.get("followers");
        this.following = (Integer) dataMap.get("following");
//        this.created_at = (String) dataMap.get("created_at");
//        this.updated_at = (String) dataMap.get("updated_at");
    }

    public int getGithub_id() {
        return github_id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public String getType() {
        return type;
    }

    public Boolean getSite_admin() {
        return site_admin;
    }

    public String getCompany() {
        return company;
    }

    public String getBlog() {
        return blog;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getHireable() {
        return hireable;
    }

    public String getBio() {
        return bio;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public int getPublic_gists() {
        return public_gists;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

//    public String getCreated_at() {
//        return created_at;
//    }
//
//    public String getUpdated_at() {
//        return updated_at;
//    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public String getTokenType() {
        return tokenType;
    }
}
