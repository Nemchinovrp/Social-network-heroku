package com.getjavajob.training.web1610.service.util;


import com.getjavajob.training.web1610.common.Phone;

import java.util.ArrayList;
import java.util.List;

public class ConvertPhoneToListString {

    public static List<String> convert(List<Phone> phones) {
        List<String> strings = new ArrayList<>();
        for (Phone temp : phones) {
            strings.add(temp.getNumber());
        }
        return strings;
    }
}
