package com.anas.javautils.jls.args;

import org.apache.commons.cli.Option;

public enum CLIOption {
    HELP("h", "help", false, "Show this help"),
    VERSION("v", "version", false, "Show version"),
    ALL("a", "all", false, "Print all files including hidden files"),
    LONG("l", "long", false, "Print the long format"),
    HUMAN_READABLE("h", "human-readable", false, "Print the human readable format"),
    SIZE("s", "size", false, "Print the size"),
    SORT_BY_SIZE("S", "", false, "Sort by size (largest first)"),
    TYPE("t", "type", false, "Print the type"),
    RECURSIVE("R", "recursive", false, "List subdirectories recursively"),
    NO_ICONS("nc", "no-icons", false, "Don't show icons"),
    ICON_COLOR("ic", "icon-color", true, "Set the icon color (like #ff0000), default is auto"),
    TEXT_COLOR("tc", "text-color", true, "Set the text color (like #ff0000), default is #ffffff");

    private final Option option;    // Apache Commons CLI Option

    CLIOption(String shortName, String longName, boolean hasArgs, String description) {
        option = new Option(shortName, longName, hasArgs, description);
    }

    public String getName() {
        return option.getOpt();
    }

    public Option getOption() {
        return option;
    }
}
