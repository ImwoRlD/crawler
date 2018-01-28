package Model;

import java.util.List;

public class TimeScore {
    public String term;
    public List<Score> scoreList;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public String toString() {
        return "TimeScore{" +
                "term=" + term +
                ", scoreList=" + scoreList +
                '}';
    }
}
