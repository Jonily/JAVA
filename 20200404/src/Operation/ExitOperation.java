package Operation;

import Book.BookList;

/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/4 10:36
 */

public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.exit(0);
        System.out.println("退出系统");
    }
}
