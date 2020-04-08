package 图书管理系统;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/8 23:11
 */

public class BookList {

    private Book[] books;

    private int useSize;

    public int getUseSize() {
        return useSize;
    }

    public void setUseSize(int useSize) {
        this.useSize = useSize;
    }

    public BookList{
        this.books = new Book[10];
        this.useSize = 3;
        this.books[0] = new Book("三国","罗贯中",20.5,"小说");
        this.books[1] = new Book("三国","罗贯中",20.5,"小说");
        this.books[2] = new Book("三国","罗贯中",20.5,"小说");



    }



}
