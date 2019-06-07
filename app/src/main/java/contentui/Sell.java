package contentui;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Sell implements Parcelable {

    private String title;
    private String author;
    private String narrator;
    private String imageURL;
    private ArrayList<Name> chapterList;
    private Where lastListenedPosition;
    private ArrayList<Mark> bookmarkList;

    protected Sell(Parcel in) {
        title = in.readString();
        author = in.readString();
        narrator = in.readString();
        imageURL = in.readString();
        chapterList = in.createTypedArrayList(Name.CREATOR);
        lastListenedPosition = in.readParcelable(Where.class.getClassLoader());
        bookmarkList = in.createTypedArrayList(Mark.CREATOR);
    }

    public static final Creator<Sell> CREATOR = new Creator<Sell>() {
        @Override
        public Sell createFromParcel(Parcel in) {
            return new Sell(in);
        }

        @Override
        public Sell[] newArray(int size) {
            return new Sell[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ArrayList<Name> getChapterList() {
        return chapterList;
    }

    public void setChapterList(ArrayList<Name> chapterList) {
        this.chapterList = chapterList;
    }

    public Where getLastListenedPosition() {
        return lastListenedPosition;
    }

    public void setLastListenedPosition(Where lastListenedPosition) {
        this.lastListenedPosition = lastListenedPosition;
    }

    public ArrayList<Mark> getBookmarkList() {
        return bookmarkList;
    }

    public void setBookmarkList(ArrayList<Mark> bookmarkList) {
        this.bookmarkList = bookmarkList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(narrator);
        parcel.writeString(imageURL);
        parcel.writeTypedList(chapterList);
        parcel.writeParcelable(lastListenedPosition, i);
        parcel.writeTypedList(bookmarkList);
    }
}
