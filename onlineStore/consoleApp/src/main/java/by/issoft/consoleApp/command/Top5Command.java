package by.issoft.consoleApp.command;

import by.issoft.store.xmlreader.SortHelper;

public class Top5Command implements Command {
    SortHelper sortHelper;

    public Top5Command(SortHelper sortHelper) {
        this.sortHelper = sortHelper;
    }

    @Override
    public void execute() {
        sortHelper.sortTop5();
    }
}
