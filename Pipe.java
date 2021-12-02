import java.util.ArrayList;
import java.util.List;

public class Pipe {

    List<Double> temperatures = new ArrayList<Double>();

    public void addTemp(Double temp)
    {
        this.temperatures.add(temp);
    }

    public Double next()  //Looking to return the temperatures here
    {
        if (temperatures.size() > 0)
            return temperatures.remove(0);
        else
            return null;
    }




}
