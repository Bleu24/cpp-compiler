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
                handleIdentifier(tokens, i, code);
                // Update i after handleIdentifier because it modifies i internally
                i = findNextNonLetterOrDigit(code, i);
            } else if (Character.isDigit(c)) {
                handleNumber(tokens, i, code);
                i = findNextNonDigit(code, i);
            } else if (c == '+') {
                handlePlus(tokens, i);
                i++;
            } else if (c == '=') {
                handleAssign(tokens, i);
                i++;
            } else if (c == '-') {
                handleMinus(tokens, i);
                i++;
            } else if (c == '*') {
                handleMultiply(tokens, i);
                i++;
            } else if (c == '/') {
                handleDivide(tokens, i);
                i++;
            } else if (c == '(') {
                handleOpenParen(tokens, i);
                i++;
            } else if (c == ')') {
                handleCloseParen(tokens, i);
                i++;
            } else {
                // Handle errors or unknown characters
                System.err.println("Error: Unknown character: " + c);
                i++;
            }
        }
        return tokens;
    }

    private int findNextNonLetterOrDigit(String code, int start) {
        int i = start;
        while (i < code.length() && Character.isLetterOrDigit(code.charAt(i))) {
            i++;
        }
        return i;
    }

    private int findNextNonDigit(String code, int start) {
        int i = start;
        while (i < code.length() && Character.isDigit(code.charAt(i))) {
            i++;
        }
        return i;
    }
        }
        return tokens;
    }
    public enum TokenType {
        KEYWORD, IDENTIFIER, NUMBER, PLUS, MINUS, MULTIPLY, DIVIDE, ASSIGN,
        OPEN_PAREN, CLOSE_PAREN
    }

    public static class Token {
        public TokenType type;
        public String value;

        public Token(TokenType type, String value) {
            this.type = type;
            this.value = value;
        }

        public TokenType getType() {
            return type;
        }

        public String getValue() {
            return value;
        }
    }

    private void handleIdentifier(List<Token> tokens, int i, String code) {
        StringBuilder sb = new StringBuilder();
        while (i < code.length() && Character.isLetterOrDigit(code.charAt(i))) {
            sb.append(code.charAt(i));
            i++;
        }
        String identifier = sb.toString();
        if (identifier.equals("int") || identifier.equals("float") ||
                identifier.equals("char") || identifier.equals("if") ||
                identifier.equals("else") || identifier.equals("while")) {
            tokens.add(new Token(TokenType.KEYWORD, identifier));
        } else {
            tokens.add(new Token(TokenType.IDENTIFIER, identifier));
        }
    }


    private void handleNumber(List<Token> tokens, int i, String code) {
        StringBuilder sb = new StringBuilder();
        while (i < code.length() && Character.isDigit(code.charAt(i))) {
            sb.append(code.charAt(i));
            i++;
        }
        tokens.add(new Token(TokenType.NUMBER, sb.toString()));
    }

    private void handlePlus(List<Token> tokens, int i) {
        tokens.add(new Token(TokenType.PLUS, "+"));
    }

    private void handleMinus(List<Token> tokens, int i) {
        tokens.add(new Token(TokenType.MINUS, "-"));
    }

    private void handleMultiply(List<Token> tokens, int i) {
        tokens.add(new Token(TokenType.MULTIPLY, "*"));
    }

    private void handleDivide(List<Token> tokens, int i) {
        tokens.add(new Token(TokenType.DIVIDE, "/"));
    }

    private void handleAssign(List<Token> tokens, int i) {
        tokens.add(new Token(TokenType.ASSIGN, "="));
    }

    private void handleOpenParen(List<Token> tokens, int i) {
        tokens.add(new Token(TokenType.OPEN_PAREN, "("));
    }

    private void handleCloseParen(List<Token> tokens, int i) {
        tokens.add(new Token(TokenType.CLOSE_PAREN, ")"));
    }
}
