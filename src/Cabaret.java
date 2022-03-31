import java.util.ArrayList;

public class Cabaret {
    private String name;
    ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Performer> getPerformers()
    {
        return performers;
    }

    public boolean addPerformer(Performer person)
    {
        ArrayList<String> performerNames = new ArrayList<>();
        for (Performer item : performers)
        {
            performerNames.add(item.getName());
        }
        if (performerNames.contains(person.getName()))
        {
            return false;
        }
        else
        {
            performers.add(person);
            return true;
        }
    }

    public boolean removePerformer(Performer person)
    {
        for (int i = 0; i < performers.size(); i++)
        {
            if (performers.get(i).getName().equals(person.getName()))
            {
                performers.remove(i);
                return true;
            }
        }
        return false;
    }

    public double averagePerformerAge()
    {
        double sum = 0.0;
        for (Performer item : performers)
        {
            sum += item.getAge();
        }
        return sum / performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> overAged = new ArrayList<>();
        for (Performer item : performers)
        {
            if (item.getAge() >= age)
            {
                overAged.add(item);
            }
        }
        return overAged;
    }

    public void groupRehearsal()
    {
        for (Performer item : performers)
        {
            System.out.println("REHEARSAL CALL! " + item.getName());
            if (item instanceof Comedian)
            {
                Comedian temp = (Comedian) item;
                temp.rehearse(false);
            }
            else
            {
                item.rehearse();
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer item : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up… " + item.getName());
            if (item instanceof Dancer)
            {
                Dancer temp = (Dancer) item;
                temp.pirouette(2);
                temp.perform(false);
            }
            else
            {
                item.perform();
            }
        }
    }
}
