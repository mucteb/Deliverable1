
package ca.sheridancollege.project;

import java.util.Objects;

public class goCard extends Card {
    
    private String value;
    private String rank;

     public goCard(String value, String rank)
     {
         super();
         setRank(rank);
         setValue(value);
     }
    
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object obj)
    {
       return this == obj;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.value);
        hash = 37 * hash + Objects.hashCode(this.rank);
        return hash;
    }
    
    @Override
    public String toString()
    {
        return "("+getRank()+getValue()+")";
    }

}
