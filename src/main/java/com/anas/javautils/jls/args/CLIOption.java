package com.anas.javautils.jls.args;

import org.apache.commons.cli.Option;

// An enum that is used to define the options that the program can take.
public enum CLIOption {
    HELP("", "help", false, "Show this help"),
    VERSION("v", "version", false, "Show version"),
    ALL("a", "all", false, "Print all files including hidden files"),
    LONG("l", "long", false, "Print the long format"),
    GROUP("G", "group", false, "Print the group"),
    HUMAN_READABLE("h", "human-readable", false, "Print the human readable format"),
    SIZE("s", "size", false, "Print the size in the short format"),
    SORT_BY_SIZE("S", "", false, "Sort by size (largest first)"),
    RECURSIVE("R", "recursive", false, "List subdirectories recursively"),
    NO_ICONS("ni", "no-icons", false, "Don't show icons"),
    ICON_COLOR("ic", "icons-color", true, "Set the icon color (like #ff0000), default is auto"),
    TEXT_COLOR("tc", "text-color", true, "Set the text color (like #ff0000), default is #ffffff"),
    NO_OWNER("no", "no-owner", false, "Don't show owner in long format"),
    NO_COLORS("nc", "no-colors", false, "Don't use colors"),
    NO_DATE("nd", "no-date", false, "Don't show date in long format"),
    NO_NAME("nn", "no-name", false, "Don't show name"),
    SORT_BY_LAST_MODIFIED("L", "", false, "Sort by last modified (latest first)"),
    NO_PERMISSIONS("np", "no-permissions", false, "Don't show the permissions in long format"),
    NO_SIZE("ns", "no-size", false, "Don't show size"),
    NO_TYPE("nt", "no-type", false, "Don't show type"),
    CONTENTS_COUNT("c", "contents-count", false, "Print the number of files in the directory"),
    TREE("t", "tree", false, "Print the tree"),
    ;
    private final Option option;    // Apache Commons CLI Option

    // A constructor.
    CLIOption(final String shortName,
              final String longName,
              final boolean hasArgs,
              final String description) {
        option = new Option(shortName, longName, hasArgs, description);
    }

    /**
     * Returns the name of the option.
     *
     * @return The name of the option.
     */
    public String getName() {
        return option.getOpt();
    }

    /**
     * This function returns the option.
     *
     * @return The option object.
     */
    public Option getOption() {
        return option;
    }
}
