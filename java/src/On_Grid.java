public class On_Grid extends Entity
{
    private Point position;
    public On_Grid(String name, Point position)
    {
        super(name);
        this.position = position;
    }

    public Point get_position()
    {
        return this.position;
    }

}