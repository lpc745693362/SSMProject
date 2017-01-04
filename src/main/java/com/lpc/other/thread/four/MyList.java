package com.lpc.other.thread.four;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liupengcheng1 on 2017/1/4.
 */
public class MyList {

    private List<String> list = new ArrayList<String>();

    public void add() {
        list.add("liupc");
    }

    public int size() {
        return list.size();
    }

}
