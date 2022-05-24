
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter_IpAddress_From_TextFile {
    static File rawFile = new File("src/test/resources/textFiles/TextFile.txt");

    @Test
    public void IpAddressFromTextFile() throws FileNotFoundException {
        String IPV4_PATTERN = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
                "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";  //"(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";//"(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";//"^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}" + "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$";
        String fullContent = "";


        Scanner reader = new Scanner(rawFile);
        while (reader.hasNextLine()) {
            String content = reader.nextLine();
            fullContent = fullContent + content;

        }
        reader.close();
        System.out.println(fullContent);
        Pattern pattern = Pattern.compile(IPV4_PATTERN); //"\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"
        Matcher matcher = pattern.matcher(fullContent);

        try {
            while (matcher.find()) {
                System.out.println();
                System.out.println(matcher.group());
            }
        } catch (Exception e) {
            System.out.println("0.0.0.0");
        }
    }




}
