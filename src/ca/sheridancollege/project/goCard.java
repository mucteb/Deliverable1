package ca.sheridancollege.project;

/**
 * @author Muharrem Kaya, 2020
 * @author Derya Kaya, 2020
 * @author Mostafa Soroush Zadeh, 2020
 */
import java.util.Objects;

public class goCard extends Card
{

    private String value;
    private String rank;

    /**
     * @param value
     * @param rank
     * @modifier Muharrem, 2020
     */
    public goCard(String value, String rank)
    {
        super();
        setRank(rank);
        setValue(value);
    }

    /**
     * @return @modifier Muharrem, 2020
     */
    public String getValue()
    {
        return value;
    }

    /**
     * @param value
     * @modifier Muharrem, 2020
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     *
     * @return rank
     * @modifier Muharrem, 2020
     */
    public String getRank()
    {
        return rank;
    }

    /**
     * @param rank
     * @modifier Muharrem, 2020
     */
    public void setRank(String rank)
    {
        this.rank = rank;
    }

    /**
     * @param obj
     * @return
     * @modifier Muharrem, 2020
     */
    @Override
    public boolean equals(Object obj)
    {
        return this == obj;
    }

    /**
     *
     * @return hash
     * @modifier Muharrem, 2020
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.value);
        hash = 37 * hash + Objects.hashCode(this.rank);
        return hash;
    }

    /**
     *
     * @return rank and value
     * @modifier Muharrem, 2020
     */
    @Override
    public String toString()
    {
        return "(" + getRank() + getValue() + ")";
    }

}
