package util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Resolver {

    public static String resolveTemplate(String template, String data){
        return String.format(template, data);
    }
    public static List<Integer>  getIntegerPriceList(List<WebElement> webElementList){
        List<Integer> priceList = new ArrayList<>();
//        priceList.add(Integer.parseInt(webElementList.get(0).getText().replace("$", "")));
//        priceList.add(Integer.parseInt(webElementList.get(1).getText().replace("$", "")));
        priceList.add(Integer.parseInt(webElementList.get(0).getText().substring(1)));
        priceList.add(Integer.parseInt(webElementList.get(1).getText().substring(1)));
        return priceList;
    }
}
