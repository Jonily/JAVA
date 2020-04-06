package Operation;

import Book.Book;
import Book.BookList;

import java.util.Scanner;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:34
 */

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("新增书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书名字：");
        String name = scanner.nextLine();
        System.out.println("请输入图书作者：");
        String author = scanner.nextLine();
        System.out.println("请输入图书价格：");
        double price = scanner.nextDouble();
        System.out.println("请输入图书类型：");
        String type = scanner.nextLine();

        Book book = new Book( name,author,price,type);
        int curSize = bookList.getUsedSize();

        bookList.setBooks(curSize,book);
        bookList.setUsedSize(curSize+1);
        System.out.println("新增书籍成功！");


    }
}
