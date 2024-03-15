package Project.Puzzle_15;

import java.util.Objects;

public class Puz {
    private String face;
    private int back;

    public Puz(String face, int back) {
        this.face = face;
        this.back = back;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Puz puz = (Puz) object;
        return back == puz.back && Objects.equals(face, puz.face);
    }

    @Override
    public int hashCode() {
        return Objects.hash(face, back);
    }

    @Override
    public String toString() {
        return face;
    }
}
