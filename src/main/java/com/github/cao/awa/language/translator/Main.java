package com.github.cao.awa.language.translator;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.github.cao.awa.language.translator.builtin.typescript.antlr.TypescriptLexer;
import com.github.cao.awa.language.translator.builtin.typescript.antlr.TypescriptParser;
import com.github.cao.awa.language.translator.builtin.typescript.translate.element.TypescriptTranslateElement;
import com.github.cao.awa.language.translator.builtin.typescript.translate.kts.TypescriptKotlinScriptTranslator;
import com.github.cao.awa.language.translator.builtin.typescript.tree.TypescriptFile;
import com.github.cao.awa.language.translator.builtin.typescript.visitor.LanguageTypescriptVisitor;
import com.github.cao.awa.language.translator.translate.LanguageTranslator;
import com.github.cao.awa.language.translator.translate.lang.TranslateTarget;
import com.github.cao.awa.sinuatum.util.io.IOUtil;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            TypescriptKotlinScriptTranslator.postRegister();

            String aps = IOUtil.read(new FileReader("samples/test.ts"));

            TypescriptFile ast = readTypescript(aps);

            ast.prepares();

            System.out.println("-- Struct ");
            JSONObject struct = new JSONObject();
            ast.generateStructure(struct);
            System.out.println(struct.toString(JSONWriter.Feature.PrettyFormat));

            System.out.println("-- Ast struct");
            ast.print();

            System.out.println("-- Generate kotlin script");

            String generatedJava = LanguageTranslator.translate(TranslateTarget.KOTLIN_SCRIPT, TypescriptTranslateElement.FILE, ast);
            System.out.println(generatedJava);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static TypescriptFile readTypescript(String content) {
        TypescriptLexer lexer = new TypescriptLexer(CharStreams.fromString(content));
        TokenStream tokens = new CommonTokenStream(lexer);
        TypescriptParser parser = new TypescriptParser(tokens);
        TypescriptParser.ProgramContext programContext = parser.program();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new RuntimeException("Expected symbol '" + offendingSymbol + "' but error in line " + line + " chars " + charPositionInLine + ": " + msg, e);
            }
        });

        printTree("", programContext);

        LanguageTypescriptVisitor visitor = new LanguageTypescriptVisitor();
        return visitor.visitProgram(programContext);
    }

    public static void printTree(String ident, ParseTree tree) {
        if (tree instanceof TerminalNode) {
            if (tree instanceof ErrorNode error) {
                System.out.println(ident + "Token: " + tree.getText() + " (" + tree.getClass().getSimpleName() + ")");
            } else {
                System.out.println(ident + "Token: " + tree.getText());
            }
        } else {
            System.out.println(ident + tree.getClass().getSimpleName());
        }
        for (int i = 0; i < tree.getChildCount(); i++) {
            printTree(ident + "    ", tree.getChild(i));
        }
    }
}