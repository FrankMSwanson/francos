package com.francos.restaurant.domain.type;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple List of potentially saleable item types
 * User: frankswanson
 * Date: 5/4/14
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public enum OfferingType {
    Appetizer("Appetizer"),
    Entree("Entree"),
    Dessert("Dessert"),
    Drink("Drink"),
    DryGood("Dry Good");

    private String display;
    private OfferingType(String display){

        this.display = display;
    }


    private static Map<String, OfferingType> displayLookup = new HashMap();
    static {

        for (OfferingType ot: EnumSet.allOf(OfferingType.class)){
            displayLookup.put(ot.getDisplay(), ot);
        }
    }

    public static OfferingType getByDisplay(String display){
        return displayLookup.get(display);
    }

    public String getDisplay(){
        return this.display;
    }
}
