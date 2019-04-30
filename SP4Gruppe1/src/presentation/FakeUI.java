package presentation;

import java.util.ArrayList;

/*
 * @author Caroline, Rikke & Nina
 */
public class FakeUI implements UI{
    
    String[] input;
    int index = 0;
    public ArrayList<String> output = new ArrayList<>();

    public FakeUI(String[] input) {
        this.input = input;
    }
    
    
}
