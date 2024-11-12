package Problems.linkedIn;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String headline;
    private String profilePicture;
    private String summary;
    private List<Experience> experience;
    private List<Education> education;
    private List<Skill> skills;

    public Profile(String headline, String profilePicture, String summary){
        this.headline = headline;
        this.profilePicture = profilePicture;
        this.summary = summary;
        this.experience = new ArrayList<>();
        this.education = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public Profile() {

    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public void setEducation(List<Education> education) {
        this.education = education;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Education> getEducation() {
        return education;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public String getHeadline() {
        return headline;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getSummary() {
        return summary;
    }
}