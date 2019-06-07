package contentui;

public class BookChapter {

    private Integer mChapterNumber;
    private Long mDuration;

    public BookChapter(Integer chapNum, Long duration) {
        mChapterNumber = chapNum;
        mDuration = duration;
    }

    public Integer getChapterNumber() {
        return mChapterNumber;
    }

    public void setChapterNumber(Integer mChapterNumber) {
        this.mChapterNumber = mChapterNumber;
    }

    public Long getDuration() {
        return mDuration;
    }

    public void setDuration(Long mDuration) {
        this.mDuration = mDuration;
    }
}

