public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
public class Main {

    public static void main(String[] args) {
        String code = "int x = 5;"; // Example C++ code

        Lexer lexer = new Lexer();
        List<Lexer.Token> tokens = lexer.tokenize(code);

        Parser parser = new Parser();
        parser.parse(tokens);

        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        analyzer.analyze(); 
    }
}
