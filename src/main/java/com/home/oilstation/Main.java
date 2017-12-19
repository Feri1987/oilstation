///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package com.home.oilstation;

import com.home.oilstation.config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 *
 * @author Denis
 */
//@ComponentScan
public class Main {

    public static void main(String[] args) {
        
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        
        
        context.close();

        

    }

}
