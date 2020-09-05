package com.zyadeh.kamel.entities;

import java.util.Objects;

public class Count extends Entity {

    private AdjectiveCount adjectiveCount;
    private NounCount nounCount;
    private CorrectSentenceCount correctSentenceCount;
    private IncorrectSentenceCount incorrectSentenceCount;
    private VerbCount verbCount;

    public AdjectiveCount getAdjectiveCount() {
        return adjectiveCount;
    }
    public void setAdjectiveCount(AdjectiveCount adjectiveCount) {
        this.adjectiveCount = adjectiveCount;
    }

    public NounCount getNounCount() {
        return nounCount;
    }
    public void setNounCount(NounCount nounCount) {
        this.nounCount = nounCount;
    }

    public VerbCount getVerbCount() {
        return verbCount;
    }
    public void setVerbCount(VerbCount verbCount) {
        this.verbCount = verbCount;
    }

    public CorrectSentenceCount getCorrectSentenceCount() {
        return correctSentenceCount;
    }

    public void setCorrectSentenceCount(CorrectSentenceCount correctSentenceCount) {
        this.correctSentenceCount = correctSentenceCount;
    }

    public IncorrectSentenceCount getIncorrectSentenceCount() {
        return incorrectSentenceCount;
    }

    public void setIncorrectSentenceCount(IncorrectSentenceCount incorrectSentenceCount) {
        this.incorrectSentenceCount = incorrectSentenceCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Count count = (Count) o;
        return Objects.equals(adjectiveCount, count.adjectiveCount) &&
                Objects.equals(nounCount, count.nounCount) &&
                Objects.equals(correctSentenceCount, count.correctSentenceCount) &&
                Objects.equals(incorrectSentenceCount, count.incorrectSentenceCount) &&
                Objects.equals(verbCount, count.verbCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), adjectiveCount, nounCount, correctSentenceCount, incorrectSentenceCount, verbCount);
    }

    @Override
    public String toString() {
        return "Count{" +
                "adjectiveCount=" + adjectiveCount +
                ", nounCount=" + nounCount +
                ", correctSentenceCount=" + correctSentenceCount +
                ", incorrectSentenceCount=" + incorrectSentenceCount +
                ", verbCount=" + verbCount +
                '}';
    }
}
