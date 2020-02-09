package com.koisoftware.monet.client.common.utils;

import com.koisoftware.monet.client.common.criteria.CompareOperator;

import java.util.LinkedHashMap;

public class SearchUtils {

    /*
     * Returns an ArrayList of Matching dropdown options
	 */
    public static LinkedHashMap<String, String> searchOptions() {
        LinkedHashMap<String, String> options = new LinkedHashMap<String, String>();
        options.put(CompareOperator.iStartsWith.name(), "Begins With");
        options.put(CompareOperator.iEquals.name(), "Exact Match");
        options.put(CompareOperator.iContains.name(), "Contains");
        return options;
    }

}
