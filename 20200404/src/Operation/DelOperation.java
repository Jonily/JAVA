package Operation;
import Book.Book;
import Book.BookList;
import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:35
 */

public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        System.out.println("请输入需要删除的图书：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int cuerSize = bookList.getUsedSize();
        int pos = 0;
        int i = 0;
        for (i = 0; i<cuerSize;i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                pos = i;
                break;

            }
        }
        if (i == cuerSize){
            System.out.println("没有需要删除的图书：");
        }
        for(int j = pos;j< cuerSize-1;j++){
            Book book = bookList.getBook(j+1);
            bookList.setBooks(j,book);
        }

        bookList.setUsedSize(cuerSize-1);
    }
}
