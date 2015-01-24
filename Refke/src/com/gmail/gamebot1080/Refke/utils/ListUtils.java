package Refke.src.com.gmail.gamebot1080.Refke.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public static String compoundList(Collection<String> list) {
        return listToEnglishCompound(list, "", "");
    }

    public static String compoundList(Collection<?> list, String prefix, String suffix) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for(Object str : list) {
            if(i != 0) {
                if(i == list.size() - 1) {
                    builder.append(" and ");
                } else {
                    builder.append(", ");
                }
            }

            builder.append(prefix).append(str).append(suffix);
            i++;
        }

        return builder.toString();
    }
