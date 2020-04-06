package Operation;

import Book.Book;
import Book.BookList;
import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:35
 */

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        System.out.println("请输入需要借阅的图书：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        for (int i = 0; i<bookList.getUsedSize();i++){
            Book book = bookList.getBook(i);

            if(book.getName().equals(name)){

                if(book.isBorrowed()){
                    System.out.println("已经被借出！");
                    return;

                }

                book.setBorrowed(true);
                System.out.println("借阅成功！");

                return;
            }
            System.out.println("没有这本书！");
     }
  }
}
