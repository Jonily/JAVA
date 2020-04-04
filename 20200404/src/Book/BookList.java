package Book;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:27
 */

public class BookList {

    private Book[] books;
    private  int usedSize;

    public  BookList(){
        this.books = new Book[10];

        this.books[0] = new Book("西游记","罗贯中",20.5,"小说");
        this.usedSize = 3;
    }

}
