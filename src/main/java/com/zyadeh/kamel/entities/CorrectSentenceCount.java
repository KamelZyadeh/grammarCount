package com.zyadeh.kamel.entities;

import java.util.Objects;

public class CorrectSentenceCount extends Entity {

    private int correctSentences;

    public int getCorrectSentences() {
        return correctSentences;
    }

    public void setCorrectSentences(int correctSentences) {
        this.correctSentences = correctSentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CorrectSentenceCount that = (CorrectSentenceCount) o;
        return correctSentences == that.correctSentences;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), correctSentences);
    }

    @Override
    public String toString() {
        return "CorrectSentenceCount{" +
                "correctSentences=" + correctSentences +
                '}';
    }
}
