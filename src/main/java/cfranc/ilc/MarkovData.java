package cfranc.ilc;

public class MarkovData {
    String theWord;
    int theCount;

    public MarkovData(String w, int c)
    {
        theWord = w;
        theCount = c;
    }

    public void setTheCount(int c)
    {
        theCount = c;
    }

    public String getTheWord()
    {
        return theWord;
    }

    public int getTheCount()
    {
        return theCount;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.theWord != null ? this.theWord.hashCode() : 0);
        hash = 97 * hash + this.theCount;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarkovData other = (MarkovData) obj;
        if (this.theCount != other.theCount) {
            return false;
        }
        if ((this.theWord == null) ? (other.theWord != null) : !this.theWord.equals(other.theWord)) {
            return false;
        }
        return true;
    }

    
}