package com.emmanuelperotto.templatemethod;

//Abstract class
public abstract class GameAI {
    // Template method
    protected final void turn() {
        collectResources();
        buildStructures();
        buildUnits();
        attack();
    }

    // concrete steps
    protected final void collectResources() {
        System.out.println("Collecting resources");
    }

    protected final void attack() {
        System.out.println("Attacking!");
    }

    // abstract steps
    protected abstract void buildStructures();
    protected abstract void buildUnits();
}
