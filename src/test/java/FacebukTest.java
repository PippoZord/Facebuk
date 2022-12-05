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

    @Test
    public void Storia3(){
        Facebuk SUT = new Facebuk(new StringReader(input));
        assertThat(SUT.amiciComuni("Filippo", "Anna")).containsExactlyInAnyOrder("Roberta", "Luca");
    }

    @Test
    public void Storia4(){
        Facebuk SUT = new Facebuk(new StringReader(input));
        assertThat(SUT.output()).isEqualTo("(Filippo Anna) [Roberta Luca]\n(Luca Anna) [Roberta Filippo]\n(Luca Filippo) [Mario Roberta Anna]\n(Mario Filippo) [Roberta Luca]\n(Mario Luca) [Roberta Filippo]\n(Mario Roberta) [Luca Filippo]\n(Roberta Anna) [Luca Filippo]\n(Roberta Filippo) [Mario Luca Anna]\n(Roberta Luca) [Mario Filippo Anna]\n");
    }
}
