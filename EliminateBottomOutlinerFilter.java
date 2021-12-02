import java.util.ArrayList;
import java.util.Collections;

public class EliminateBottomOutlinerFilter extends Filter{

    public EliminateBottomOutlinerFilter(Pipe inputPipe, Pipe outputPipe)	//Creating a pipe
    {
        super( inputPipe, outputPipe);	//Send var. to parent class as ref. using the constructor
    }
    @Override
    public void transform(){
        ArrayList<Double> temps = new ArrayList<Double>();

        Double next = inputPipe.next();    //Getting first element from input pipe

        //While there is a next value
        while(next != null)
        {

            temps.add(next);   //add the next value to values
            next = inputPipe.next();   //Setting next variable to next element in the inputPipe
        }

        //Variable to represent minimum value in the list using the Collections utility
        Double min = Collections.min(temps);

        System.out.println("Given Values: "+ temps);   //Logging given values
        temps.remove(min);                             //Removing min value from list
        System.out.println("Min value removed: "+ temps);

        //Loops over the values ArrayList
        for (int i = 0; i <temps.size(); i++)
        {
            outputPipe.addTemp( temps.get(i));    //Sending values in ArrayList
        }
    }
}
