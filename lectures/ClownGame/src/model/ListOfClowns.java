package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListOfClowns {
    List<Clown> clowns = new ArrayList<Clown>();

    //TODO: Implement this method
    //REQUIRES: boolean value isStanding, indicating whether the clown should be constructed sitting or standing
    //MODIFIES: the list clowns
    //EFFECTS:  creates a new Clown, passing in the isStanding parameter, and adds that clown to the list of clowns
    public void addClown(boolean isStanding) {
        Clown c=new Clown(isStanding);
            clowns.add(c);
        }


    //TODO: Implement this method
    //REQUIRES: nothing
    //MODIFIES: nothing
    //EFFECTS:  checks all the Clowns in the list clowns, and returns true if every clown is standing
    public boolean allClownsStanding() {
        boolean state= true;
for (Clown c:clowns){
    if (!c.getIsStanding())
         state=false;
}
        return state;
    }

    //TODO: Implement this method
    //REQUIRES: an integer value for the clown's index in the list clowns (position)
    //MODIFIES: the clown at the position, and the clown to either side (position+1 and position-1) of the clown
    //EFFECTS:  calls clown.flip() to make a clown sit if standing, or stand if sitting.
    //          changes nothing and takes no action if position is out of bounds of the list.
    public void flip(int position) {
        if (position == 0&&clowns.size()==1) {
            clowns.get(position).flip();
        }
        if (position == 0&&clowns.size()>1) {
            clowns.get(position).flip();
            clowns.get(position + 1).flip();
        }
        if (position == clowns.size() - 1&&clowns.size()>1) {
            clowns.get(position).flip();
            clowns.get(position - 1).flip();
        }
        if (position > 0&&position<clowns.size()-1&&clowns.size()>1) {
            clowns.get(position).flip();
            clowns.get(position - 1).flip();
            clowns.get(position + 1).flip();
        }
    }

    //TODO: Implement this method
    //REQUIRES: an integer value for the clown's index in the list of clowns (position)
    //MODIFIES: nothing
    //EFFECTS:  returns true if the Clown in the list clowns at index position is standing, false otherwise
    //          returns false if position is out of bounds of the list.
    public boolean isClownStanding(int position) {
        if (position < clowns.size()) {
            return clowns.get(position).standing;
        }
        return false;
    }

    //Do not modify this method
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Clown c : clowns) {
            if (c.getIsStanding()) {
                sb.append("  UP  ");
            } else {
                sb.append(" DOWN ");
            }
        }
        return sb.toString();
    }
}