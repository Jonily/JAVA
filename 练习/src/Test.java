import java.io.*;

public class Test {
    public static void main (String[] args){
        try {
            FileReader fileReader = new FileReader("D:\\course.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s = bufferedReader.readLine();
            while (s!=null){
                System.out.println(s);
                bufferedReader.readLine();

            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
