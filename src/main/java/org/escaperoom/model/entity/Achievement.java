package org.escaperoom.model.entity;

import java.time.LocalDateTime;

public class Achievement {
    private int id;
    private int playerId;
    private int roomId;
    private String description;
    private LocalDateTime achievementDate;
    private boolean rewardGiven;

    public Achievement() {
    }

    public Achievement(int id, int playerId, int roomId, String description, LocalDateTime achievementDate, boolean rewardGiven) {
        this.id = id;
        this.playerId = playerId;
        this.roomId = roomId;
        this.description = description;
        this.achievementDate = achievementDate;
        this.rewardGiven = rewardGiven;
    }

    public Achievement(int playerId, int roomId, String description, LocalDateTime achievementDate, boolean rewardGiven) {
        this.playerId = playerId;
        this.roomId = roomId;
        this.description = description;
        this.achievementDate = achievementDate;
        this.rewardGiven = rewardGiven;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getAchievementDate() {
        return achievementDate;
    }

    public void setAchievementDate(LocalDateTime achievementDate) {
        this.achievementDate = achievementDate;
    }

    public boolean isRewardGiven() {
        return rewardGiven;
    }

    public void setRewardGiven(boolean rewardGiven) {
        this.rewardGiven = rewardGiven;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", roomId=" + roomId +
                ", description='" + description + '\'' +
                ", achievementDate=" + achievementDate +
                ", rewardGiven=" + rewardGiven +
                '}';
    }
}
