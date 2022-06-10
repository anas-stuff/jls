package com.anas.javautils.jls.args;

import org.apache.commons.cli.Option;

public enum CLIOption {
    HELP("", "help", false, "Show this help"),
    VERSION("v", "version", false, "Show version"),
    ALL("a", "all", false, "Print all files including hidden files"),
    LONG("l", "long", false, "Print the long format"),
    GROUP("G", "group", false, "Print the group"),
    HUMAN_READABLE("h", "human-readable", false, "Print the human readable format"),
    SIZE("s", "size", false, "Print the size"),
    SORT_BY_SIZE("S", "", false, "Sort by size (largest first)"),
    RECURSIVE("R", "recursive", false, "List subdirectories recursively"),
    NO_ICONS("nc", "no-icons", false, "Don't show icons"),
    ICON_COLOR("ic", "icons-color", true, "Set the icon color (like #ff0000), default is auto"),
    TEXT_COLOR("tc", "text-color", true, "Set the text color (like #ff0000), default is #ffffff"),
    NO_OWNER("", "no-owner", false, "Don't show owner in long format"),
    NO_COLORS("", "no-colors", false, "Don't use colors"),
    NO_DATE("nd", "no-date", false, "Don't show date in long format"),
    NO_NAME("nn", "no-name", false, "Don't show name"),
    SORT_BY_LAST_MODIFIED("L", "", false, "Sort by last modified (latest first)");
    private final Option option;    // Apache Commons CLI Option

    CLIOption(final String shortName,
              final String longName,
              final boolean hasArgs,
              final String description) {
        option = new Option(shortName, longName, hasArgs, description);
    }

    public String getName() {
        return option.getOpt();
    }

    public Option getOption() {
        return option;
    }
}
