package com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol;

import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.arithmetic.*;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.assignment.*;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.comparing.*;
import com.github.cao.awa.language.translator.builtin.typescript.tree.statement.control.calculate.symbol.not.TypescriptNotSymbol;

public class ApsOperators {
    public static final TypescriptNotSymbol NOT = new TypescriptNotSymbol(null);

    public static final TypescriptMinusSymbol MINUS = new TypescriptMinusSymbol(null);
    public static final TypescriptPlusSymbol PLUS = new TypescriptPlusSymbol(null);
    public static final TypescriptMultiplySymbol MULTIPLY = new TypescriptMultiplySymbol(null);
    public static final TypescriptDivideSymbol DIVIDE = new TypescriptDivideSymbol(null);
    public static final TypescriptPowSymbol POW = new TypescriptPowSymbol(null);

    public static final TypescriptSubtractionAssignmentSymbol SUBTRACTION_ASSIGNMENT = new TypescriptSubtractionAssignmentSymbol(null);
    public static final TypescriptAdditionAssignmentSymbol ADDITION_ASSIGNMENT = new TypescriptAdditionAssignmentSymbol(null);
    public static final TypescriptMultiplicationAssignmentSymbol MULTIPLICATION_ASSIGNMENT = new TypescriptMultiplicationAssignmentSymbol(null);
    public static final TypescriptDivisionAssignmentSymbol DIVISION_ASSIGNMENT = new TypescriptDivisionAssignmentSymbol(null);
    public static final TypescriptPowAssignmentSymbol POW_ASSIGNMENT = new TypescriptPowAssignmentSymbol(null);

    public static final TypescriptEqualsSymbol EQUALS = new TypescriptEqualsSymbol(null);

    public static final TypescriptMoreThanSymbol MORE_THAN = new TypescriptMoreThanSymbol(null);
    public static final TypescriptLessThanSymbol LESS_THAN = new TypescriptLessThanSymbol(null);

    public static final TypescriptAndSymbol AND = new TypescriptAndSymbol(null);
    public static final TypescriptBreakingAndSymbol BREAKING_AND = new TypescriptBreakingAndSymbol(null);
    public static final TypescriptOrSymbol OR = new TypescriptOrSymbol(null);
    public static final TypescriptBreakingOrSymbol BREAKING_OR = new TypescriptBreakingOrSymbol(null);

    public static final int PAREN_LEVEL = Integer.MAX_VALUE;
}
