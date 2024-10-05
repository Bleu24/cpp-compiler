import java.util.ArrayList;
import java.util.List;

public class Lexer {

    public List<Token> tokenize(String code) {
        List<Token> tokens = new ArrayList<>();
        int i = 0;
        while (i < code.length()) {
            char c = code.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            if (Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < code.length() && Character.isLetterOrDigit(code.charAt(i))) {
                    sb.append(code.charAt(i));
                    i++;
                }
                tokens.add(new Token("IDENTIFIER", sb.toString()));
            } else if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < code.length() && Character.isDigit(code.charAt(i))) {
                    sb.append(code.charAt(i));
                    i++;
                }
                tokens.add(new Token("NUMBER", sb.toString()));
            } else if (c == '+') {
                tokens.add(new Token("PLUS", "+"));
                i++;
            } else if (c == '-') {
                tokens.add(new Token("MINUS", "-"));
                i++;
            } else if (c == '*') {
                tokens.add(new Token("MULTIPLY", "*"));
                i++;
            } else if (c == '/') {
                tokens.add(new Token("DIVIDE", "/"));
                i++;
            } else if (c == '(') {
                tokens.add(new Token("OPEN_PAREN", "("));
                i++;
            } else if (c == ')') {
                tokens.add(new Token("CLOSE_PAREN", ")"));
                i++;
            } else {
                // Handle errors or unknown characters
                System.err.println("Error: Unknown character: " + c);
                i++; 
            }
        }
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
