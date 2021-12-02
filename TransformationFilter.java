import java.util.ArrayList;

public class TransformationFilter extends Filter{

    public TransformationFilter(Pipe inputPipe, Pipe outputPipe)	//Creating a pipe
    {
        super( inputPipe, outputPipe);	//Send var. to parent class as ref. using the constructor
    }

    @Override
    public void transform(){
        ArrayList<Double> values = new ArrayList<Double>();

        Double next = inputPipe.next();    //Getting first element from input pipe

        //While there is a next value
        while(next != null)
        {

            values.add(next);   //add the next value to values
            next = inputPipe.next();   //Setting next variable to next element in the inputPipe
        }

        System.out.println("Given Values in Celsius: " + values);          //Logging given values

        //Looping over values
        for(int i = 0; i < values.size();i++)
        {
            double celsius = values.get(i);                 //Gets value in celsius
            double fahrenheit = ((celsius * (9.0 / 5.0)) + 32);     //changes celsius to fahrenheit

            values.set(i, fahrenheit);                      //Setting the index of the value to the new converted fahrenheit value
        }


        System.out.println("Converted values to Farhenheit: "); //System logging converted values

        for (int i = 0; i < values.size(); i++)
        {
            System.out.println(values.get(i));
        }

    }
}
