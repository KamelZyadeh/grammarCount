package com.zyadeh.kamel.entities;

import java.util.Objects;

public class NounCount extends Entity {

    private int noun;

    public int getNoun() {
        return noun;
    }

    public void setNoun(int noun) {
        this.noun = noun;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NounCount nounCount = (NounCount) o;
        return noun == nounCount.noun;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), noun);
    }

    @Override
    public String toString() {
        return "NounCount{" +
                "noun=" + noun +
                '}';
    }
}
