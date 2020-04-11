/**
 * @Description:
 * @Author HuangZhuoLin
 * @Date 2020/4/11 23:48
 */

public class BookStore {
    private String name;//书店名称
    private String address;//地址
    private Book[] books;//书籍的数组
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }
    public Book[] getBooks() {
        return books;
    }
    public BookStore(String name,String address,Book[] books)
    {
        setName(name);
        setAddress(address);
        setBooks(books);
    }

    //卖一本书的方法
    /*
     * 该方法需要两个参数，一个是顾客一个是顾客要买的书
     */
    public void sellBook(Customer customer,Book book)
    {
        if(customer.getMoney()>=book.getPrice())
        //首先判断顾客的现金够不够支付这本书的价格
        {
            for(int i=0;i<books.length;i++)
            {
                if(books[i]!=null)
                {
                    //假定书店中的所有书是不重名的
                    if(books[i].getName().equals(book.getName()))
                    {
                        books[i]=null;//把对应位置的书籍对象设置为空，表示该书已经售出
                        customer.setMoney(customer.getMoney()-book.getPrice());
                        //处理顾客的余额
                        System.out.println(customer.getName()+"买了"+book.getName()+"这本书");
                        break;//退出循环
                    }
                }
            }
        }
        else
        {
            System.out.println(customer.getName()+"现金不够");
        }
    }
}
