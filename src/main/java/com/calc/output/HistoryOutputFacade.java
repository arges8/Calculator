package com.calc.output;

import com.calc.arithmetic.store.ProxyCacheStore;

public class HistoryOutputFacade {
    private HistoryTextUpdaterFacade historyTextUpdaterFacade = HistoryTextUpdaterFacade.getInstance();
    private ProxyCacheStore cacheStore;

    public HistoryOutputFacade() {
        cacheStore = ProxyCacheStore.getInstance();
    }

    public void createOutputForHistoryButton() {
        historyTextUpdaterFacade.updateTextArea(cacheStore.getHistory());
    }
}
