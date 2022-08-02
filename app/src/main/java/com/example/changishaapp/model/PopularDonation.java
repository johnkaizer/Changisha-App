package com.example.changishaapp.model;

public class PopularDonation {
    String Title;
    String Amount;
    String Description;
    Integer ImageUrl;
    String Progress;
    String Category;
    String Duration;
    String Id;

    public PopularDonation(String title, String amount, String description, Integer imageUrl, String progress, String category, String duration) {
        Title = title;
        Amount = amount;
        Description = description;
        ImageUrl = imageUrl;
        Progress = progress;
        Category = category;
        Duration = duration;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getProgress() {
        return Progress;
    }

    public void setProgress(String progress) {
        Progress = progress;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }
}
