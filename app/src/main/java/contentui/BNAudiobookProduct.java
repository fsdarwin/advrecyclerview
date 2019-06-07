package contentui;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class BNAudiobookProduct implements Parcelable {

    private String title;
    private String author;
    private String narrator;
    private String imageURL;
    private ArrayList<BNAudiobookChapter> chapterList;
    private BNAudiobookPosition lastListenedPosition;
    private ArrayList<BNAudioBookBookmark> bookmarkList;

    protected BNAudiobookProduct(Parcel in) {
        title = in.readString();
        author = in.readString();
        narrator = in.readString();
        imageURL = in.readString();
        chapterList = in.createTypedArrayList(BNAudiobookChapter.CREATOR);
        lastListenedPosition = in.readParcelable(BNAudiobookPosition.class.getClassLoader());
        bookmarkList = in.createTypedArrayList(BNAudioBookBookmark.CREATOR);
    }

    public static final Creator<BNAudiobookProduct> CREATOR = new Creator<BNAudiobookProduct>() {
        @Override
        public BNAudiobookProduct createFromParcel(Parcel in) {
            return new BNAudiobookProduct(in);
        }

        @Override
        public BNAudiobookProduct[] newArray(int size) {
            return new BNAudiobookProduct[size];
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

    public ArrayList<BNAudiobookChapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(ArrayList<BNAudiobookChapter> chapterList) {
        this.chapterList = chapterList;
    }

    public BNAudiobookPosition getLastListenedPosition() {
        return lastListenedPosition;
    }

    public void setLastListenedPosition(BNAudiobookPosition lastListenedPosition) {
        this.lastListenedPosition = lastListenedPosition;
    }

    public ArrayList<BNAudioBookBookmark> getBookmarkList() {
        return bookmarkList;
    }

    public void setBookmarkList(ArrayList<BNAudioBookBookmark> bookmarkList) {
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
