package contentui;

import android.os.Parcel;
import android.os.Parcelable;

public class BNAudiobookChapter implements Parcelable {

    private int part;
    private int chapter;
    private long duration;

    public BNAudiobookChapter(int part, int chapter, long duration) {
        this.part = part;
        this.chapter = chapter;
        this.duration = duration;
    }

    protected BNAudiobookChapter(Parcel in) {
        part = in.readInt();
        chapter = in.readInt();
        duration = in.readLong();
    }

    public static final Creator<BNAudiobookChapter> CREATOR = new Creator<BNAudiobookChapter>() {
        @Override
        public BNAudiobookChapter createFromParcel(Parcel in) {
            return new BNAudiobookChapter(in);
        }

        @Override
        public BNAudiobookChapter[] newArray(int size) {
            return new BNAudiobookChapter[size];
        }
    };

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(part);
        parcel.writeInt(chapter);
        parcel.writeLong(duration);
    }
}
