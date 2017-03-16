package sudopkill.facebook;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import sudopkill.AuthProvider.AuthProvider;
import sudopkill.account.Account;

import javax.persistence.Entity;

/**
 * Created by tanzeelrana on 3/7/2017.
 */
@Entity
public class FacebookAccount extends Account {

    private String fb_id;
    private String age_range;
    private String birthday;
    private String cover;
    private String currency;
    private String first_name;
    private String gender;
    private Boolean is_verified;
    private String last_name;
    private String link;
    private String middle_name;
    private String relationship_status;
    private String religion;
    private Float timezone;
    private Boolean verified;
    private Boolean viewer_can_send_gift;
    private String website;

    private String remoteAddress;
    private String sessionId;
    private String tokenValue;
    private String tokenType;

    public FacebookAccount(){}

    public FacebookAccount(Facebook facebook, OAuth2Authentication auth){

        String[] fieldsToMap = { "id", "about", "age_range", "birthday",
                "context", "cover", "currency", "devices", "education",
                "email", "favorite_athletes", "favorite_teams",
                "first_name", "gender", "hometown", "inspirational_people",
                "installed", "install_type", "is_verified", "languages",
                "last_name", "link", "location", "meeting_for",
                "middle_name", "name", "name_format", "political",
                "quotes", "payment_pricepoints", "relationship_status",
                "religion", "security_settings", "significant_other",
                "sports", "test_group", "timezone", "third_party_id",
                "updated_time", "verified", "viewer_can_send_gift",
                "website", "work" };

        User userProfile = facebook.fetchObject("me", User.class, fieldsToMap);
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)auth.getDetails();

        this.remoteAddress = details.getRemoteAddress();
        this.sessionId = details.getSessionId();
        this.tokenValue = details.getTokenValue();
        this.tokenType = details.getTokenType();


        this.setPassword("");
        this.setRole("ROLE_USER");
        this.setAuthProvider(AuthProvider.FACEBOOK.toString());
        this.setName(userProfile.getName());
        this.setId(  (String) auth.getName()  );
        this.setEmail(userProfile.getEmail());
        this.setAbout(userProfile.getAbout());
        System.out.println("profile bio : " + userProfile.getAbout());
        this.setProfilePicture("http://graph.facebook.com/" + userProfile.getId() + "/picture?type=square");

        System.out.println("profile picture : " + this.getProfilePicture());

        this.fb_id = userProfile.getId();

        this.age_range = userProfile.getAgeRange().name();
        this.birthday = userProfile.getBirthday();
        this.cover = userProfile.getCover().getSource();
        this.currency = userProfile.getCurrency().getUserCurrency();
        this.first_name = userProfile.getFirstName();
        this.gender = userProfile.getGender();
        this.is_verified = userProfile.isVerified();
        this.last_name = userProfile.getLastName();
        this.link = userProfile.getLink();
        this.middle_name = userProfile.getMiddleName();

        this.relationship_status = userProfile.getRelationshipStatus();
        this.religion = userProfile.getReligion();
        this.timezone = userProfile.getTimezone();
        this.verified = userProfile.isIdentityVerified();
        this.viewer_can_send_gift = userProfile.viewerCanSendGift();
        this.website = userProfile.getWebsite();
    }

    public String getFb_id() {
        return fb_id;
    }

    public String getAge_range() {
        return age_range;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCover() {
        return cover;
    }

    public String getCurrency() {
        return currency;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getGender() {
        return gender;
    }

    public Boolean getIs_verified() {
        return is_verified;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getLink() {
        return link;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getRelationship_status() {
        return relationship_status;
    }

    public String getReligion() {
        return religion;
    }

    public Float getTimezone() {
        return timezone;
    }

    public Boolean getVerified() {
        return verified;
    }

    public Boolean getViewer_can_send_gift() {
        return viewer_can_send_gift;
    }

    public String getWebsite() {
        return website;
    }

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
