package com.huoli.Main;

import com.huoli.Index.Index;

public class Main {

    public static void main(String[] arg) {
        Index index = new Index();
        Thread th = new Thread(index);
        th.start();
    }
}
