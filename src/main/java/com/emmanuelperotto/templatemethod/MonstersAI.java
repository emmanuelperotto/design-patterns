package com.emmanuelperotto.templatemethod;

public class MonstersAI extends GameAI {
    @Override
    protected void buildStructures() {
        System.out.println("Building house");
    }

    @Override
    protected void buildUnits() {
        System.out.println("Building gremlins");
    }
}
