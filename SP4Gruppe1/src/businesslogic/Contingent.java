package businesslogic;

/*
 * @author Rikke, Nina, Kristine & Caroline
 */
public class Contingent {

    private int under18;
    private int between18And60;
    private int over60;
    private int passive;

    public Contingent(int under18, int between18And60, int over60, int passive) {
        this.under18 = under18;
        this.between18And60 = between18And60;
        this.over60 = over60;
        this.passive = passive;
    }

    public int getUnder18() {
        return under18;
    }

    public void setUnder18(int under18) {
        this.under18 = under18;
    }

    public int getBetween18And60() {
        return between18And60;
    }

    public void setBetween18And60(int between18And60) {
        this.between18And60 = between18And60;
    }

    public int getOver60() {
        return over60;
    }

    public void setOver60(int over60) {
        this.over60 = over60;
    }

    public int getPassive() {
        return passive;
    }

    public void setPassive(int passive) {
        this.passive = passive;
    }

    @Override
    public String toString() {
        return "Contingent:"
                + "\nUnder 18 =\t\t" + under18
                + "\nBetween 18 and 60 =\t" + between18And60
                + "\nOver 60 =\t\t" + over60 
                + "\nPassive =\t\t" + passive;
    }
}
