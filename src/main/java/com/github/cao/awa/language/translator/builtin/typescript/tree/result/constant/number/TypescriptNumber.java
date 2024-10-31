package com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.number;

import com.github.cao.awa.language.translator.builtin.typescript.tree.result.constant.TypescriptConstant;
import com.github.cao.awa.language.translator.translate.tree.LanguageAst;

import java.math.BigDecimal;

public class TypescriptNumber extends TypescriptConstant<BigDecimal> {
    private static final BigDecimal INT_MAX = new BigDecimal(String.valueOf(Integer.MAX_VALUE));
    private static final BigDecimal LONG_MAX = new BigDecimal(String.valueOf(Long.MAX_VALUE));
    private static final BigDecimal DOUBLE_MAX = new BigDecimal(String.valueOf(Double.MAX_VALUE));
    private static final BigDecimal FLOAT_MAX = new BigDecimal(String.valueOf(Float.MAX_VALUE));

    private BigDecimal value = null;
    private boolean isBigDecimal = false;
    private String suffix = "";

    public TypescriptNumber(LanguageAst parent) {
        super(parent);
    }

    public void value(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String literal() {
        if (this.isBigDecimal) {
            return "BigDecimal(\"" + this.value.toString() + "\")";
        } else {
            return this.value.toString() + this.suffix;
        }
    }

    @Override
    public BigDecimal constantValue() {
        return this.value;
    }

    @Override
    public void preprocess() {
        try {
            if (literal().contains(".")) {
                int compareDouble = this.value.compareTo(DOUBLE_MAX);
                if (compareDouble >= 1) {
                    this.isBigDecimal = true;
                }
            }

            int compareInt = this.value.compareTo(INT_MAX);
            if (compareInt >= 1) {
                int compareLong = this.value.compareTo(LONG_MAX);
                if (compareLong < 1) {
                    this.suffix = "L";
                } else {
                    this.isBigDecimal = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
