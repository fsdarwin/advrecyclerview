package contentui;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class BNAudioBookBookmark implements Parcelable {

    private int id;
    private BNAudiobookPosition bookmarkPosition;
    private long modifiedTime;
    private String note;

    BNAudioBookBookmark(int id, BNAudiobookPosition bookmarkPosition, long modifiedTime, String note) {
        this.id = id;
        this.bookmarkPosition = bookmarkPosition;
        this.modifiedTime = modifiedTime;
        this.note = note;
    }

    protected BNAudioBookBookmark(Parcel in) {
        id = in.readInt();
        bookmarkPosition = in.readParcelable(BNAudiobookPosition.class.getClassLoader());
        modifiedTime = in.readLong();
        note = in.readString();
    }

    public static final Creator<BNAudioBookBookmark> CREATOR = new Creator<BNAudioBookBookmark>() {
        @Override
        public BNAudioBookBookmark createFromParcel(Parcel in) {
            return new BNAudioBookBookmark(in);
        }

        @Override
        public BNAudioBookBookmark[] newArray(int size) {
            return new BNAudioBookBookmark[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BNAudiobookPosition getBookmarkPosition() {
        return bookmarkPosition;
    }

    public void setBookmarkPosition(BNAudiobookPosition bookmarkPosition) {
        this.bookmarkPosition = bookmarkPosition;
    }

    public long getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(long modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isNoteAvailable() {
        return !TextUtils.isEmpty(note);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeParcelable(bookmarkPosition, i);
        parcel.writeLong(modifiedTime);
        parcel.writeString(note);
    }
}
