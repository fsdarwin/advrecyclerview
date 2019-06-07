package contentui;

import java.util.ArrayList;
import java.util.List;

public class BookPart implements Parent<BookChapter> {

    private Integer mPartNumber;
    private ArrayList<BookChapter> mBookChapters;
    private Long mPartDuration;
    private boolean isExpanded = false;

    public BookPart(Integer number) {
        mPartNumber = number;
    }

    public BookPart(Integer number, ArrayList<BookChapter> BookChapters) {
        mPartNumber = number;
        mBookChapters = BookChapters;
    }

    public BookPart(Integer number, ArrayList<BookChapter> BookChapters, Long duration) {
        mPartNumber = number;
        mBookChapters = BookChapters;
        mPartDuration = duration;
    }

    public Integer getPartNumber() {
        return mPartNumber;
    }

    @Override
    public List<BookChapter> getChildList() {
        return mBookChapters;
    }

    public void addChildToList(BookChapter newChapter) {
        if (mBookChapters == null) {
            mBookChapters = new ArrayList<>();
        }
        mBookChapters.add(newChapter);
    }

    public Long getPartDuration() {
        return mPartDuration;
    }

    public void addToPartDuration(Long durationIn) {
        if (mPartDuration == null) {
            mPartDuration = Long.valueOf(0);
        }
        mPartDuration += durationIn;
    }


    @Override
    public boolean isInitiallyExpanded() {
        return isExpanded;
    }

    public void setIsInitiallyExpanded(boolean toExpandOrNotToExpand) {
        isExpanded = toExpandOrNotToExpand;
    }
}
