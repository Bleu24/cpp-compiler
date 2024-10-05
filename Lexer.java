import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public List<Token> tokenize(String code) {
        List<Token> tokens = new ArrayList<>();
        // TODO: Implement tokenization logic here
        return tokens;
    }

    // Inner class to represent tokens
    public static class Token {
        public String type;
        public String value;

        public Token(String type, String value) {
            this.type = type;
            this.value = value;
        }
    }
}
