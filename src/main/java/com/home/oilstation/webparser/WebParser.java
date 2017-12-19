/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.webparser;

import com.home.oilstation.entity.Oil;

/**
 *
 * @author Denis
 */
public interface WebParser {

    Oil parse(String url);

}
