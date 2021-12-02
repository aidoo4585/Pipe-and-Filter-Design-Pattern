import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Collections;

public class EliminateTopOutlinerFilter extends Filter {

    public EliminateTopOutlinerFilter(Pipe inputPipe, Pipe outputPipe)	//Creating a pipe
    {
        super( inputPipe, outputPipe);	//Send var. to parent class as ref. using the constructor
    }

    @Override
    public void transform() {
        //ArrayList to store inputted values
        ArrayList<Double> temps = new ArrayList<Double>();

        Double next = inputPipe.next();    //Getting first element from input pipe

        //While there is a next value
        while(next != null)
        {

            temps.add(next);   //add the next value to values
            next = inputPipe.next();   //Setting next variable to next element in the inputPipe
        }

        //Variable to represent max value in the list using the Collections utility
        Double max = Collections.max(temps);

        System.out.println("Given Values: "+ temps);   //Logging given values
        temps.remove(max);                             //Removing min value from list
        System.out.println("Max value removed: "+ temps);

        //Loops over the values ArrayList
        for (int i = 0; i <temps.size(); i++)
        {
            outputPipe.addTemp(temps.get(i));    //Sending values in ArrayList
        }
    }

    }

