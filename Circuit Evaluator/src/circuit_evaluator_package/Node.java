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
public class Node {
    private double voltage;
    private ArrayList<Terminal> connections;
    private boolean isGroundNode;
    
    Node(Terminal[] terminals) {
        connections = new ArrayList<>();
        for(Terminal t: terminals)
            connections.add(t);
        isGroundNode = false;
        voltage = 0;
    }
    
    Node(Terminal term1, Terminal term2) {
        connections = new ArrayList<>();
        connections.add(term1);
        connections.add(term2);
        isGroundNode = false;
        voltage = 0;
    }
    
    Node(Terminal[] terminals, boolean isGroundNode) {
        connections = new ArrayList<>();
        for(Terminal t: terminals)
            connections.add(t);
        this.isGroundNode = isGroundNode;
        voltage = 0;
    }
    
    Node(Terminal term1, Terminal term2, boolean isGroundNode) {
        connections = new ArrayList<>();
        connections.add(term1);
        connections.add(term2);
        this.isGroundNode = isGroundNode;
        voltage = 0;
    }
    
    double getVoltage() {
        return voltage;
    }
    
    void setVoltage(double voltage) {
        this.voltage = voltage;
    }
    
    boolean isGroundNode() {
        return isGroundNode;
    }
    
    void setAsGroundNode(boolean isGroundNode) {
        this.isGroundNode = isGroundNode;
    }
    
    void addConnections(Terminal connection) {
        connections.add(connection);
    }
    
    boolean contains(Terminal term) {
        if(connections.isEmpty() || term == null)
            return false;
        for(Terminal t: connections)
            if(t.getID() == term.getID()){
                return true;
            }   
        return false;
    }
    
    void printTerminals(){
        for(Terminal t: connections){
            System.out.println("\t" + t.toString());
        }
    }
}