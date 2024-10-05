import java.util.List;

public class Parser {

    private final List<Token> tokens;
    private int currentToken;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.currentToken = 0;
    }

    public void parse() {
        // TODO: Implement parsing logic
    }

    private void consume(TokenType expectedType) {
        Token token = tokens.get(currentToken);
        if (token.getType() == expectedType) {
            currentToken++;
        } else {
            // TODO: Handle parsing error
        }
    }
}
