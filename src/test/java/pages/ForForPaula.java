package pages;

import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class ForForPaula {
    @Test
    public void petlaFor() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("src/test/resources/file.txt"));



        for (int i = 0; i < 1001; i++) {
            RandomString rs = new RandomString(new Random().nextInt(15)+1);
            RandomString rs2 = new RandomString(new Random().nextInt(20)+1);
             System.out.println(i+"-"+rs.nextString()+"@mail.com, "+rs2.nextString());
            writer.println(i+"-"+rs.nextString()+"@mail.com, "+rs.nextString());
        } writer.close();
    }
}
