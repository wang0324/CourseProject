public class Interest {
    private String interest;
    private int interestID;

    /** CONSTRUCTORS */

    public Interest(int interestID, String interest) {
        this.interest = interest;
        this.interestID = interestID;
    }

    /** ACCESORS */

    public String getInterest() {
        return interest;
    }

    public int getinterestID() {
        return interestID;
    }

    /** MUTATORS */

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void setInterestID(int interestID) {
        this.interestID = interestID;
    }


    /** ADDITIONAL OPERATIONS */

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (!(o instanceof Interest)) {
            return false;
        }
        else {
            Interest i = (Interest) o;
            if (i.interest.equals(this.interest)){
                if (i.interestID == this.interestID) {
                    return true;
                }
            }
            return false;
        }

    }

    /**
     * Returns a consistent hash code for each Interest by summing the Unicode
     * values of each character in the key Key = interest + interstID
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        String key = interest + interestID;
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int)key.charAt(i);
        }
        return sum;
    }


}