public abstract class Filter {
    protected Pipe inputPipe;	//Need refs. to both input and output pipes
    protected Pipe outputPipe;

    public Filter(Pipe inputPipe, Pipe outputPipe)	//ref for the pipe are sent outside filter, so constructor to instant. var.
    {
        this.inputPipe = inputPipe;
        this.outputPipe = outputPipe;
    }

    abstract public void transform();
}
