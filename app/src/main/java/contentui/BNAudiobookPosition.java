package contentui;

import android.os.Parcel;
import android.os.Parcelable;

public class BNAudiobookPosition implements Parcelable {

    private int part;
    private int chapter;
    private int position;

    public BNAudiobookPosition(int part, int chapter, int position) {
        this.part = part;
        this.chapter = chapter;
        this.position = position;
    }

    protected BNAudiobookPosition(Parcel in) {
        part = in.readInt();
        chapter = in.readInt();
        position = in.readInt();
    }

    public static final Creator<BNAudiobookPosition> CREATOR = new Creator<BNAudiobookPosition>() {
        @Override
        public BNAudiobookPosition createFromParcel(Parcel in) {
            return new BNAudiobookPosition(in);
        }

        @Override
        public BNAudiobookPosition[] newArray(int size) {
            return new BNAudiobookPosition[size];
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(part);
        parcel.writeInt(chapter);
        parcel.writeInt(position);
    }
}
