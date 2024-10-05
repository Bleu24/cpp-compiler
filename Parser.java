import java.util.List;

public class Parser {

    public void parse(List<Lexer.Token> tokens) {
        // TODO: Implement parsing logic here
        if (tokens.isEmpty()) {
            return;
        }

        // Example: Parsing a simple expression like "1 + 2"
        int currentToken = 0; 

        // Example: Parsing a simple expression like "1 + 2"
        if (tokens.size() >= 3 &&
                tokens.get(currentToken).getType() == Lexer.TokenType.NUMBER &&
                tokens.get(currentToken + 1).getType() == Lexer.TokenType.PLUS &&
                tokens.get(currentToken + 2).getType() == Lexer.TokenType.NUMBER) {
            int num1 = Integer.parseInt(tokens.get(currentToken).getValue());
            int num2 = Integer.parseInt(tokens.get(currentToken + 2).getValue());
            int result = num1 + num2;
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid expression");
        }

    }
}
