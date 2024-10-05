import java.util.List;

public class Parser {

    public void parse(List<Lexer.Token> tokens) {
        // TODO: Implement parsing logic here
        if (tokens.isEmpty()) {
            return;
        }

        // Example: Parsing a simple expression like "1 + 2"
        if (tokens.size() >= 3 &&
                tokens.get(0).getType() == Lexer.TokenType.NUMBER &&
                tokens.get(1).getType() == Lexer.TokenType.PLUS &&
                tokens.get(2).getType() == Lexer.TokenType.NUMBER) {
            int num1 = Integer.parseInt(tokens.get(0).getValue());
            int num2 = Integer.parseInt(tokens.get(2).getValue());
            int result = num1 + num2;
            System.out.println("Result: " + result);
        } else {
            System.out.println("Invalid expression");
        }
        

    }
}
