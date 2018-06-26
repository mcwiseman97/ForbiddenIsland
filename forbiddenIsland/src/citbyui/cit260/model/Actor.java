/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import citbyui.cit260.model.Card;
/**
 *
 * @author mcwis
 */
public class Actor implements Serializable{

    private String name;
    private double coordinates;
    private String specialAbility;
    private Location Location;
    private Card cards;
    private ArrayList<Player> player = new ArrayList<Player>();
    
    public Actor() {
    }

    public Actor(String name, double coordinates, String specialAbility) {
        this.name = name;
        this.coordinates = coordinates;
        this.specialAbility = specialAbility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double coordinates) {
        this.coordinates = coordinates;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    public ArrayList<Player> getPlayer() {
        return player;
    }

    public void setPlayer(ArrayList<Player> player) {
        this.player = player;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location Location) {
        this.Location = Location;
    }

    public Card getCards() {
        return cards;
    }

    public void setCards(Card cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", coordinates=" + coordinates + ", specialAbility=" + specialAbility + ", Location=" + Location + ", player=" + player + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.coordinates) ^ (Double.doubleToLongBits(this.coordinates) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.specialAbility);
        hash = 67 * hash + Objects.hashCode(this.Location);
        hash = 67 * hash + Objects.hashCode(this.player);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (Double.doubleToLongBits(this.coordinates) != Double.doubleToLongBits(other.coordinates)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.specialAbility, other.specialAbility)) {
            return false;
        }
        if (!Objects.equals(this.Location, other.Location)) {
            return false;
        }
        if (!Objects.equals(this.player, other.player)) {
            return false;
        }
        return true;
    }


    
    
    
}
