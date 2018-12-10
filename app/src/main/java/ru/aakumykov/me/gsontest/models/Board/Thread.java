package ru.aakumykov.me.gsontest.models.Board;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thread {

    @Expose
    private Long banned;
    @Expose
    private Long closed;
    @Expose
    private String comment;
    @Expose
    private String date;
    @Expose
    private String email;
    @Expose
    private Long endless;
    @Expose
    private List<File> files;
    @SerializedName("files_count")
    private Long filesCount;
    @Expose
    private Long lasthit;
    @Expose
    private String name;
    @Expose
    private String num;
    @Expose
    private Long op;
    @Expose
    private String parent;
    @SerializedName("posts_count")
    private Long postsCount;
    @Expose
    private Long sticky;
    @Expose
    private String subject;
    @Expose
    private String tags;
    @Expose
    private Long timestamp;
    @Expose
    private String trip;

    public Long getBanned() {
        return banned;
    }

    public void setBanned(Long banned) {
        this.banned = banned;
    }

    public Long getClosed() {
        return closed;
    }

    public void setClosed(Long closed) {
        this.closed = closed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getEndless() {
        return endless;
    }

    public void setEndless(Long endless) {
        this.endless = endless;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Long getFilesCount() {
        return filesCount;
    }

    public void setFilesCount(Long filesCount) {
        this.filesCount = filesCount;
    }

    public Long getLasthit() {
        return lasthit;
    }

    public void setLasthit(Long lasthit) {
        this.lasthit = lasthit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Long getOp() {
        return op;
    }

    public void setOp(Long op) {
        this.op = op;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Long getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(Long postsCount) {
        this.postsCount = postsCount;
    }

    public Long getSticky() {
        return sticky;
    }

    public void setSticky(Long sticky) {
        this.sticky = sticky;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

}
