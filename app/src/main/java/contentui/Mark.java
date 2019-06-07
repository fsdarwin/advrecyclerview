package contentui;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class Mark implements Parcelable {

    private int id;
    private Where bookmarkPosition;
    private long modifiedTime;
    private String note;

    Mark(int id, Where bookmarkPosition, long modifiedTime, String note) {
        this.id = id;
        this.bookmarkPosition = bookmarkPosition;
        this.modifiedTime = modifiedTime;
        this.note = note;
    }

    protected Mark(Parcel in) {
        id = in.readInt();
        bookmarkPosition = in.readParcelable(Where.class.getClassLoader());
        modifiedTime = in.readLong();
        note = in.readString();
    }

    public static final Creator<Mark> CREATOR = new Creator<Mark>() {
        @Override
        public Mark createFromParcel(Parcel in) {
            return new Mark(in);
        }

        @Override
        public Mark[] newArray(int size) {
            return new Mark[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Where getBookmarkPosition() {
        return bookmarkPosition;
    }

    public void setBookmarkPosition(Where bookmarkPosition) {
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
