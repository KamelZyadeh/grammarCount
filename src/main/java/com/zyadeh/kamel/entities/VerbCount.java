package com.zyadeh.kamel.entities;

import java.util.Objects;

public class VerbCount extends Entity {

    private int verbs;

    public int getVerbs() {
        return verbs;
    }

    public void setVerbs(int verbs) {
        this.verbs = verbs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VerbCount verbCount = (VerbCount) o;
        return verbs == verbCount.verbs;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), verbs);
    }

    @Override
    public String toString() {
        return "VerbCount{" +
                "verbs=" + verbs +
                '}';
    }
}
