package com.getjavajob.training.web1610.webapp.util;


import com.getjavajob.training.web1610.common.Phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteNullValueFromList {
    public static void main(String[] args) {
        String[] array = {null, null, "Hello"};
        List<String> test = Arrays.asList(array);
        System.out.println(new DeleteNullValueFromList().cleanNull(test).size());
    }

    public static List<Phone> clean(List<Phone> phones) {
        List<Phone> result = new ArrayList<>();
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).getNumber() != null) {
                result.add(phones.get(i));
            }
        }
        return result;
    }

    public List<String> cleanNull(List<String> strings) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i) != null) {
                result.add(strings.get(i));
            }
        }
        return result;
    }
}
