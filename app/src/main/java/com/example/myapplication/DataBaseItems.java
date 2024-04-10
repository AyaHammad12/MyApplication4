package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class DataBaseItems {
    private List<MenueItem> items=new ArrayList<>();
    public DataBaseItems(){

        items.add(new MenueItem("Coffee", 10, "Hot Drinks"));
        items.add(new MenueItem("Tea", 8, "Hot Drinks"));
        items.add(new MenueItem("Ice Coffee", 15, "Cold Drinks"));
        items.add(new MenueItem("Sprite", 5, "Cold Drinks"));
        items.add(new MenueItem("Chicken Sandwitch", 20, "Sandwitches"));
    }

    public List<MenueItem> getMenueItems(String category) {
        List<MenueItem> result =new ArrayList<>();
        for (MenueItem m:items){
            if (m.getCategory().equals(category)){
                result.add(m);
            }
        }
        return result;
    }
    public String[] getCategories(){
     //assume we are reading data from dataBase
         String[] categories={"Hot Drinks", "Cold Drinks", "Sandwitches"};
        return  categories;
    }
}
