package com.zyadeh.kamel.entities;

import java.util.Objects;

public class IncorrectSentenceCount extends Entity {

    private int incorrectSentences;

    public int getIncorrectSentences() {
        return incorrectSentences;
    }

    public void setIncorrectSentences(int incorrectSentences) {
        this.incorrectSentences = incorrectSentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncorrectSentenceCount that = (IncorrectSentenceCount) o;
        return incorrectSentences == that.incorrectSentences;
    }

    @Override
    public int hashCode() {

        return Objects.hash(incorrectSentences);
    }

    @Override
    public String toString() {
        return "IncorrectSentenceCount{" +
                "incorrectSentences=" + incorrectSentences +
                '}';
    }
}
