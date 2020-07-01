package com.calc.controller;

import com.calc.screen.ScreenLoaderService;

public class HistoryController implements Controller{

    private ScreenLoaderService screenLoader;

    @Override
    public void setScreenLoader(ScreenLoaderService screenLoader) {
        this.screenLoader = screenLoader;
    }
}
