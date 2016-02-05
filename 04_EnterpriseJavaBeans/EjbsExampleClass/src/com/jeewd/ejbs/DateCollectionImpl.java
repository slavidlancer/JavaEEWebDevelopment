package com.jeewd.ejbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class DateCollectionImpl implements DateCollection {
    private List<String> dates = new ArrayList<>();
    
    @Override
    public String addAndReturn() {
        dates.add((new Date()).toString());
        
        return Arrays.toString(dates.toArray());
    }
}
