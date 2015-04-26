/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package circuit_evaluator_package;

import java.util.ArrayList;

/**
 *
 * @author mtbjj
 */

public class Terminal {
    private static int counter = 0;
    private ArrayList<Terminal> connections = new ArrayList();
    private int numConnections;
    Element element;
    private final int ID;
    Terminal(Element element) {
        ID = counter++;
        this.element = element;
    }
    
    Element getElement() {
        return element;
    }
    
    Terminal[] getConnections(Terminal terminal) {
        ArrayList<Terminal> connectedTo = connections;
        connectedTo.remove(terminal);
        return (Terminal[]) connectedTo.toArray();
    }
    
    Terminal[] getConnections() {
        return (Terminal[]) connections.toArray();
    }
    
    boolean containsVoltageSource() {
        for(Terminal e: connections)
            if(e.getClass().equals(VoltageSource.class))
                return true;
        return false;
    }
    
    boolean containsCurrentSource() {
        for(Terminal e: connections)
            if(e.getClass().equals(CurrentSource.class))
                return true;
        return false;
    }
    
    boolean connect(Terminal terminal) {
        numConnections++;
        connections.add(terminal);
        return true;
    }
    
    int getID(){
        return ID;
    }
    
    @Override
    public String toString(){
        String returnStr = "" + element.getName();
        if(this.equals(element.terminal1))
            returnStr += " @ terminal 1";
        else 
            returnStr += " @ terminal 2";
        return returnStr + " with ID: " + ID;
    }
}
