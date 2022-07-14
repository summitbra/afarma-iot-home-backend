package com.summitbra.afarma.iot.home.backend.util;

import com.summitbra.afarma.iot.home.backend.data.GraphicValueDTO;
import com.summitbra.afarma.iot.home.backend.responses.ResponseMedia;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeUtil {


    public static ResponseMedia getPercentage(Double total, Double ok ){
        if(total>0){
            Double result = (ok*100)/total;
            DecimalFormat f = new DecimalFormat("#.## ");
            return new ResponseMedia(HomeUtil.formatString(f.format(result)));
        }
        return null;
    }

    public static List<GraphicValueDTO> getGraphicValue(List<GraphicValueDTO> graphicValues){
        if(graphicValues.size()==12){
                return graphicValues;
            }else {
            return HomeUtil.getList(graphicValues);
        }

    }


    public static List<GraphicValueDTO> getList(List<GraphicValueDTO> graphicValues){
        List<GraphicValueDTO> newList = new ArrayList<>();
        for (int i =1; i<=12;i++){
            newList.add(new GraphicValueDTO(String.valueOf(i), 0L));
        }
        if(graphicValues.size()==0){
            return newList;
        }else{
            for(int i =0; i<newList.size();i++){
                for (int j =0; j<graphicValues.size();j++){
                    if(Objects.equals(newList.get(i).getMonth(), graphicValues.get(j).getMonth())){
                        newList.get(i).setCount(graphicValues.get(j).getCount());
                    }
                }
            }
        }
        return newList;
    }



    public static String formatString(String s){
        return s.replaceAll(" ", "%");
    }
}
