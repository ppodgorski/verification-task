package com.ppodgorski.verificationtask.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    @SerializedName("data")
    List<String> dataList;

}
