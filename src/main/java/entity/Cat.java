/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;

/**
 *
 * @author makis
 */
@Entity
public class Cat extends Animal {

    @Override
    public String makeNoise() {
        return "woof woof ...";
    }
}
