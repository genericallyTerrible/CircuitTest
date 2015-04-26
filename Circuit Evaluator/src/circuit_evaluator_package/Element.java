/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package circuit_evaluator_package;

/**
 *
 * @author mtbjj
 */

public abstract class Element {
    final int x;
    final int y;
    
    private double voltage;
    private double current;
    private double value;
    
    String name;
    Terminal terminal1;
    Terminal terminal2;
    
    Element(double value, String name) {
        this.value = value;
        this.name = name;
        x = 0;
        y = 0;
        terminal1 = new Terminal(this);
        terminal2 = new Terminal(this);
    }
    double getVoltage() {
        return voltage;
    }
    double getCurrent() {
        return current;
    }
    double getValue() {
        return value;
    }
    void reset() {
        voltage = 0;
        current = 0;
        value = 0;
    }
    
    String getName(){
        return name;
    }
    
    abstract void update(long t);
    @Override
    public abstract String toString();
}
