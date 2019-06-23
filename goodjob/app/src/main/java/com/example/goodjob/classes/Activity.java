package com.example.goodjob.classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Activity implements Parcelable {

    // TODO: probablemente me estoy olvidando de varios campos, agregarlos con confianza.

    private Integer id;
    private String title;
    private String description;
    private String author;
    private String creationDate;
    private String endDate;
    private Integer currentParticipants;
    private Integer requiredParticipants;
    private Integer photo;
    private Integer status;

    public Activity(Integer id, String title, String description, String author,
                    String creationDate, String endDate, Integer currentParticipants,
                    Integer requiredParticipants, Integer photo, Integer status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.creationDate = creationDate;
        this.endDate = endDate;
        this.currentParticipants = currentParticipants;
        this.requiredParticipants = requiredParticipants;
        this.photo = photo;
        this.status = status;
    }

    public Activity(){};

    protected Activity(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        description = in.readString();
        author = in.readString();
        creationDate = in.readString();
        endDate = in.readString();
        if (in.readByte() == 0) {
            currentParticipants = null;
        } else {
            currentParticipants = in.readInt();
        }
        if (in.readByte() == 0) {
            requiredParticipants = null;
        } else {
            requiredParticipants = in.readInt();
        }
        if (in.readByte() == 0) {
            photo = null;
        } else {
            photo = in.readInt();
        }
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readInt();
        }
    }

    public static final Creator<Activity> CREATOR = new Creator<Activity>() {
        @Override
        public Activity createFromParcel(Parcel in) {
            return new Activity(in);
        }

        @Override
        public Activity[] newArray(int size) {
            return new Activity[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(Integer currentParticipants) {
        this.currentParticipants = currentParticipants;
    }

    public Integer getRequiredParticipants() {
        return requiredParticipants;
    }

    public void setRequiredParticipants(Integer requiredParticipants) {
        this.requiredParticipants = requiredParticipants;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(title);
        parcel.writeString(description);
        parcel.writeString(author);
        parcel.writeString(creationDate);
        parcel.writeString(endDate);
        if (currentParticipants == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(currentParticipants);
        }
        if (requiredParticipants == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(requiredParticipants);
        }
        if (photo == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(photo);
        }
        if (status == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(status);
        }
    }
}
