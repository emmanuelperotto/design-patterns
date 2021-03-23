package com.emmanuelperotto.templatemethod;

public class OrcsAI extends GameAI {
    @Override
    protected void buildStructures() {
        System.out.println("Building farms, then barracks, then stronghold");
    }

    @Override
    protected void buildUnits() {
        System.out.println("Building grunt and adding it warriors group");
    }
}
