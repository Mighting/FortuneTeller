package zbc.assignment.fortuneteller;

public class Fortune
{
    private String fortune;

    public String getFortune ()
    {
        return fortune;
    }

    public void setFortune (String fortune)
    {
        this.fortune = fortune;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [fortune = "+fortune+"]";
    }
}
