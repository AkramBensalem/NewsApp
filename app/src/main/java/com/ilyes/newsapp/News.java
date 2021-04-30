package com.ilyes.newsapp;

/**
 * Created by moham on 10/2/2017.
 */

public class News {
    private String mTitle;
    private String mDate;
    private String mUrl;
    private String mAuthor;
    private String mSection;

    public News(String title, String date, String url, String author, String section) {
        mTitle = title;
        mDate = date;
        mUrl = url;
        mAuthor = author;
        mSection = section;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String section) {
        mSection = section;
    }

    @Override
    public String toString() {
        return  " title "    + getTitle();

    }
}