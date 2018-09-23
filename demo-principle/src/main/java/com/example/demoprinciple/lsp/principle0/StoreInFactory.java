package com.example.demoprinciple.lsp.principle0;

/**
 * @author shipengfish
 * @description
 * @date 2018/9/13
 * @since 1.0
 */
public class StoreInFactory {
    private CodeGenerator codeGenerator;

    public StoreInFactory(CodeGenerator codeGenerator) {
        this.codeGenerator = codeGenerator;
    }

    public void generate() {
        codeGenerator.generate();
    }
}