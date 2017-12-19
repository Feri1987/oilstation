/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.oilstation.webparser.impl;

import com.home.oilstation.entity.Oil;
import com.home.oilstation.entity.OilMaker;
import com.home.oilstation.entity.OilProduct;
import com.home.oilstation.entity.OilType;
import com.home.oilstation.webparser.WebParser;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Denis
 */
public class WebParserAvtomaniyaImpl implements WebParser {

    public WebParserAvtomaniyaImpl() {
    }

    public Oil parse(String url) {
        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element table = doc.select("table").first();

        Elements rows = table.select("tr");
        OilProduct product = null;
        OilType oilType = null;
        OilMaker oilMaker = null;
        List<OilType> oilTypes = new ArrayList<OilType>();
        List<OilMaker> oilMakers = new ArrayList<OilMaker>();
        List<OilProduct> listProducts = new ArrayList<OilProduct>();

        for (int i = 0; i < rows.size() - 1; i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");

            for (int j = 0; j < cols.size(); j++) {
                oilType = new OilType();
                oilMaker = new OilMaker();
                product = new OilProduct();

                if ((i == 0) && (j >= 2)) {
                    oilType.setId(j - 2);
                    oilType.setName(cols.get(j).text());
                    oilTypes.add(oilType);

                }
                if ((i >= 1) && (j == 1)) {
                    oilMaker.setId(i - 1);
                    oilMaker.setName(cols.get(j).text());
                    oilMakers.add(oilMaker);
                }
                if ((i >= 1) && (j >= 2) && !(cols.get(j).text().equals("-"))) {
                    product.setOilType(oilTypes.get(j - 2));
                    product.setOilMaker(oilMakers.get(i - 1));
                    product.setPrice(new BigDecimal(cols.get(j).text()));
                    listProducts.add(product);
                }
                System.out.print(" " + cols.get(j).text());
            }
            System.out.println();

        }
        
        return new Oil(oilTypes, oilMakers, listProducts);

    }
}
