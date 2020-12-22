package util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Resolver<Generic> {

    public static String resolveTemplate(String template, String data){
        return String.format(template, data);
    }

    public static List  getIntegerPriceList(List<WebElement> webElementList){
        List<Integer> priceList = new ArrayList<>();
        priceList.add(Integer.parseInt(webElementList.get(0).getText().substring(1)));
        priceList.add(Integer.parseInt(webElementList.get(1).getText().substring(1)));
        return priceList;
    }

    public static List<Double>  getDoublePriceList(List<WebElement> webElementList){
        List<Double> priceList = new ArrayList<>();
        priceList.add(Double.parseDouble(webElementList.get(0).getText().substring(2)));
        priceList.add(Double.parseDouble(webElementList.get(1).getText().substring(2)));
        return priceList;
    }
}
