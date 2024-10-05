import java.util.List;

public class Main {

    public static void main(String[] args) {
        String code = "var x = 10;";

        Lexer lexer = new Lexer(code);
        List<Token> tokens = lexer.tokenize();

        Parser parser = new Parser(tokens);
        parser.parse();

        // TODO: Implement semantic analysis and code generation
    }
}
