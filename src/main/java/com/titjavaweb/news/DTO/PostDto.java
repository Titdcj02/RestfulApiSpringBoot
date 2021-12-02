package com.titjavaweb.news.DTO;

public class PostDto extends AbstractDto<PostDto> {
    private String title;
    private String content;
    private String categoryCode;
    private String shortDescription;
    private String thumbnail;

    public PostDto(String title, String content, String categoryCode, String shortDescription, String thumbnail) {
        this.title = title;
        this.content = content;
        this.categoryCode = categoryCode;
        this.shortDescription = shortDescription;
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public PostDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
