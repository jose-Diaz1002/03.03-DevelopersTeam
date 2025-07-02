package org.escaperoom.model.entity;

import java.time.LocalDateTime;

public class Achievement {
    private int id;
    private int player_id;
    private int room_id;
    private String description;
    private LocalDateTime achievement_date;
    private boolean reward_given;

    public Achievement() {
    }

    public Achievement(int id, int player_id, int room_id, String description, LocalDateTime achievement_date, boolean reward_given) {
        this.id = id;
        this.player_id = player_id;
        this.room_id = room_id;
        this.description = description;
        this.achievement_date = achievement_date;
        this.reward_given = reward_given;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getAchievement_date() {
        return achievement_date;
    }

    public void setAchievement_date(LocalDateTime achievement_date) {
        this.achievement_date = achievement_date;
    }

    public boolean isReward_given() {
        return reward_given;
    }

    public void setReward_given(boolean reward_given) {
        this.reward_given = reward_given;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "id=" + id +
                ", player_id=" + player_id +
                ", room_id=" + room_id +
                ", description='" + description + '\'' +
                ", achievement_date=" + achievement_date +
                ", reward_given=" + reward_given +
                '}';
    }
}
