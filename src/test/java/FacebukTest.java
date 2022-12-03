import org.example.Facebuk;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.StringReader;

import static org.assertj.core.api.Assertions.*;



@Timeout(2)
public class FacebukTest {

    private final static String input = "Mario Roberta Luca Filippo\nRoberta Mario Luca Filippo Anna\nLuca Mario Roberta Filippo Anna\nFilippo Mario Roberta Luca Anna\nAnna Roberta Luca Filippo\n";
    @Test
    public void Storia1_2(){
        Facebuk SUT = new Facebuk(new StringReader(input));
        assertThat(SUT.toString()).isEqualTo("Mario Roberta Luca Filippo \nRoberta Mario Luca Filippo Anna \nLuca Mario Roberta Filippo Anna \nFilippo Mario Roberta Luca Anna \nAnna Roberta Luca Filippo \n");
    }

}
