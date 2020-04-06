package Operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:37
 */

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍");
        System.out.println("请输入需要归还的图书：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        for (int i = 0; i<bookList.getUsedSize();i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setBorrowed(false);
                System.out.println("归还成功！");
                return;
            }
      }
        System.out.println("没有这本书！");
    }
}
