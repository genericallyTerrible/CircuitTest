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

public class Resistor extends Element{

    
    public Resistor(double value, String name) {
        super(value, name);
    }
    
    @Override
    void update(long t) {
        //if(terminal1.containsVoltageSource())
            
    }
    
    @Override
    public String toString() {
        return "r";
    }
    
}
