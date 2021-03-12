import control.FENParser;
import org.junit.Test;

public class FenParserTest {

    @Test
    public void startingFEN() {
        String startFEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        String FEN2 = "rnbqkbnr/pppppppp/8/8/4P3/8/PPPP1PPP/RNBQKBNR";
        FENParser.parse(startFEN);
        FENParser.parse(FEN2);
    }
}
