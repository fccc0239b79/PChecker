/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pchecker;

/**
 *
 * @author Tomasz
 */
public class SystemLogic {
    int comp;
    
    public int compatibility(int cpu, int gpu, int ram, int cooling, int hdd, int acc, int pcCase){
            
        comp = cpu + gpu + ram + cooling + hdd + acc + pcCase;
        
        comp = comp / 7 ;
        
            return comp;
}
}
