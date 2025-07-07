package org.escaperoom.model;

public class AchievementCertificate {
        private int id;
        private String title;
        private String description;
        private String dateAwarded; // Podrías usar LocalDate si quieres un tipo más adecuado

     public AchievementCertificate(int id, String title, String description, String dateAwarded) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateAwarded = dateAwarded;
        }

    public AchievementCertificate() {
        }

    public int getId() {
        return id;
        }

    public void setId(int id) {
        this.id = id;
        }

    public String getTitle() {
        return title;
        }

    public void setTitle(String title) {
        this.title = title;
        }

    public String getDescription() {
        return description;
        }

    public void setDescription(String description) {
        this.description = description;
        }

    public String getDateAwarded() {
        return dateAwarded;
        }

    public void setDateAwarded(String dateAwarded) {
        this.dateAwarded = dateAwarded;
        }

     @Override
        public String toString() {
        return "AchievementCertificate [id=" + id + ", title=" + title + ", description=" + description
                + ", dateAwarded=" + dateAwarded + "]";
        }
    }