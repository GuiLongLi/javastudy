package input;

import java.io.*;

public class InputStreamReader {
    public static void main(String args[]) throws  IOException{
        char c;
        String s;
        //使用System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        System.out.println("输出字符,按下q 键退出。");
        //读取字符
        do{
            c = (char) br.read();
            System.out.println(c);
            s = String.valueOf(c);
            System.out.println(s);
            System.out.println(!s.equals("q"));
        }while (!s.equals("q"));
    }
}
