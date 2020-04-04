package Operation;

import Book.BookList;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:35
 */

public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("书籍");
    }
}
