package Operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:35
 */

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查找的图书：");
        String name = scanner.nextLine();

        for (int i = 0; i<bookList.getUsedSize();i++){
             Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println(book);

                System.out.println("查找到这本书！");
                return;

            }
        }
        System.out.println("没有这本书！");

    }
}
