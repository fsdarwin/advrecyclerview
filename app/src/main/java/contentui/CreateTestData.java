package contentui;

import android.util.Log;

import java.util.ArrayList;

public class CreateTestData {

    public static final String TAG = "Frank ";

    public static ArrayList<Sell> getProducts(int size) {

        if (size > 0) {

            ArrayList<Sell> productData = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                int num = i + 1;
                String title = "Title_" + num;
                String author = "Author_" + num;
                String narator = "Narator_" + num;
                String image = "ImageURL_" + num;
                ArrayList<Name> chapters = getChapters(size);
                Where position = getSinglePosition();
                ArrayList<Mark> bookmarks = getBookmarks(size);
            }

            return productData;
        }
        Log.d(TAG, "getProducts: size was null or less than 1.");
        return null;
    }


    public static ArrayList<Mark> getBookmarks(int size) {

        if (size > 0) {
            ArrayList<Mark> bookmarkData = new ArrayList<>();

            ArrayList<Where> BmPositions = getPositions(size);

            for (int i = 0; i < size; i++) {
                long modifiedTime = System.currentTimeMillis();
                int num = i + 1;
                String note;
                if (i % 3 == 0) {
                    note = "This is a note placeholder. It holds a place for a note here. It does a really god job of holding a place for a note. I think it deserves an award for note place holding.";
                    bookmarkData.add(new Mark(num, BmPositions.get(i), modifiedTime, note));
                } else {
                    note = "";
                    bookmarkData.add(new Mark(num, BmPositions.get(i), modifiedTime, note));
                }
            }
            return bookmarkData;
        }
        return null;
    }

    public static ArrayList<Where> getPositions(int number) {

        if (number > 0) {
            ArrayList<Where> positionData = new ArrayList<>();

            for (int i = 0; i < number; i++) {
                int chap = i + 1;
                int pos = (int) (Math.random() * 7200);
                positionData.add(new Where(0, chap, pos));
            }
            return positionData;
        }
        return null;
    }

    public static Where getSinglePosition() {

        Where positionData;

        int chap = (int) (Math.random() * 21);
        int pos = (int) (Math.random() * 7200);
        positionData = new Where(0, chap, pos);

        return positionData;

    }

    public static ArrayList<Name> getChapters(int size) {

        if (size > 0) {
            ArrayList<Name> chapters = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < 5; i++) {
                    int part = j;
                    int chap = i;
                    long dur = (long) (Math.random() * 7200000);
                    chapters.add(new Name(part, chap, dur));
                }
            }
            return chapters;
        }
        return null;
    }

    public static ArrayList<BookPart> getPartsAndChapters(int size) {
        ArrayList<Name> chapterData;
        ArrayList<BookPart> bookPartList = null;
        BookPart bookPart = null;
        BookChapter bookChapter;

        chapterData = CreateTestData.getChapters(4);
        for (int i = 0; i < chapterData.size(); i++) {
            Log.d(TAG, "onCreate: part = " + chapterData.get(i).getPart() + ", chapter = " +
                    chapterData.get(i).getChapter() + ", dur = " + chapterData.get(i).getDuration());
        }
        Integer part = 0;
        for (int i = 0; i < chapterData.size(); i++) {
            int currentPart = chapterData.get(i).getPart();
            bookChapter = new BookChapter(chapterData.get(i).getChapter(), chapterData.get(i).getDuration());
            if (bookPart == null || bookPart.getPartNumber() != currentPart) {
                bookPart = new BookPart(currentPart);
                bookPartList.add(bookPart);
                bookPartList.get(currentPart).addChildToList(bookChapter);
            } else {
                bookPartList.get(currentPart).addChildToList(bookChapter);
            }
        }
        return bookPartList;
    }
}