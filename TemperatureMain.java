import java.util.ArrayList;

public class TemperatureMain {
    public static void main(String[] kenny){
        //Creating list of temps
        double[] temperature = {4.5, 12.7, 11, 18.9, 7.90, 5.32};
        int i = 0;

        Pipe firstPipe = new Pipe();
            for(i = 0; i < temperature.length; i++) //End condition for loop
            {
                firstPipe.addTemp(temperature[i]);                         //Sending temps into pipe
            }

        Pipe removedMax = new Pipe();
        EliminateTopOutlinerFilter EliminateTopOutlinerFilter = new EliminateTopOutlinerFilter(firstPipe,removedMax); //inputPipe,outputPipe
        EliminateTopOutlinerFilter.transform();	//keeping refs. to the outputs bc those are input to other filters

        Pipe removedMin = new Pipe();
        EliminateBottomOutlinerFilter EliminateBottomOutlinerFilter = new EliminateBottomOutlinerFilter(removedMax,removedMin);
        EliminateBottomOutlinerFilter.transform();

        // sink
        Pipe tempConverted = new Pipe();
        TransformationFilter TransformationFilter = new TransformationFilter(removedMin, tempConverted);
        TransformationFilter.transform();


    }


}
