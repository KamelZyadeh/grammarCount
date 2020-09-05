package com.zyadeh.kamel.entities;

import java.util.Objects;

public class AdjectiveCount extends Entity {

    private int adj;

    public int getAdj() {
        return adj;
    }

    public void setAdj(int adj) {
        this.adj = adj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AdjectiveCount that = (AdjectiveCount) o;
        return adj == that.adj;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), adj);
    }

    @Override
    public String toString() {
        return "AdjectiveCount{" +
                "adj=" + adj +
                '}';
    }
}
