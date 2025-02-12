package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void hasCityTest() {
        list = MockCityList();
        City mockCity = new City("TestCity", "TestProvince");
        assertFalse(list.hasCity(mockCity));
        list.addCity(mockCity);
        assertTrue(list.hasCity(mockCity));
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City mockCity = new City("TestCity", "TestProvince");
        list.addCity(mockCity);
        assertTrue(list.hasCity(mockCity));
        list.deleteCity(mockCity);
        assertFalse(list.hasCity(mockCity));
    }

    @Test
    public void getCountTest() {
        list = MockCityList();
        City mockCity = new City("TestCity", "TestProvince");
        assertEquals(0, list.getCount());
        list.addCity(mockCity);
        assertEquals(1, list.getCount());
    }

}
