package window;

import java.io.*;
import java.util.*;

public class window {
    public static void main(String[] args) throws IOException {
        Properties properties = System.getProperties();
        String osName = properties.getProperty("os.name");
        System.out.println (osName);
        if (osName.indexOf("Linux") != -1) {
            Runtime.getRuntime().exec("step:htmlview");
        } else if (osName.indexOf("Windows") != -1){
            Runtime.getRuntime().exec("explorer http://www.baidu.com");
        } else {
            throw new RuntimeException("Unknown OS.");
        }
    }
}
