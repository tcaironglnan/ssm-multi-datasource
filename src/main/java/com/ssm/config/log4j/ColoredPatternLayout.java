package com.ssm.config.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

import java.util.StringTokenizer;

/**
 * log4j打印信息格式化
 * @author x
 * @Created 2018-1-29 10:56
 */
public class ColoredPatternLayout extends PatternLayout {
    private static final String CONFIGURATION_SEPARATOR = "/";

    private static final String PREFIX = "\u001b[";
    private static final String SUFFIX = "m";
    private static final char SEPARATOR = ';';
    private static final String END_COLOR = PREFIX + SUFFIX;

    private static final String ATTR_NORMAL = "0";
    private static final String ATTR_BRIGHT = "1";
    private static final String ATTR_DIM = "2";
    private static final String ATTR_UNDERLINE = "3";
    private static final String ATTR_BLINK = "5";
    private static final String ATTR_REVERSE = "7";
    private static final String ATTR_HIDDEN = "8";

    private static final String FG_BLACK = "30";
    private static final String FG_RED = "31";
    private static final String FG_GREEN = "32";
    private static final String FG_YELLOW = "33";
    private static final String FG_BLUE = "34";
    private static final String FG_MAGENTA = "35";
    private static final String FG_CYAN = "36";
    private static final String FG_WHITE = "37";

    private static final String BG_BLACK = "40";
    private static final String BG_RED = "41";
    private static final String BG_GREEN = "42";
    private static final String BG_YELLOW = "44";
    private static final String BG_BLUE = "44";
    private static final String BG_MAGENTA = "45";
    private static final String BG_CYAN = "46";
    private static final String BG_WHITE = "47";
    private static final String BG_NULL = "NULL";

    private String fatalErrorColor = PREFIX + ATTR_DIM + SEPARATOR + FG_RED + SUFFIX;
    private String errorColor = PREFIX + ATTR_DIM + SEPARATOR + FG_RED + SUFFIX;
    private String warnColor = PREFIX + ATTR_DIM + SEPARATOR + FG_MAGENTA + SUFFIX;
    private String infoColor = PREFIX + ATTR_DIM + SEPARATOR + FG_GREEN + SUFFIX;
    private String debugColor = PREFIX + ATTR_DIM + SEPARATOR + FG_WHITE + SUFFIX;

    public ColoredPatternLayout() {
        super();
    }

    public ColoredPatternLayout(String pattern) {
        super(pattern);
    }

    @Override
    public String format(LoggingEvent event) {
        if (event.getLevel() == Level.FATAL) {
            return fatalErrorColor + super.format(event) + END_COLOR;
        } else if (event.getLevel() == Level.ERROR) {
            return errorColor + super.format(event) + END_COLOR;
        } else if (event.getLevel() == Level.WARN) {
            return warnColor + super.format(event) + END_COLOR;
        } else if (event.getLevel() == Level.INFO) {
            return infoColor + super.format(event) + END_COLOR;
        } else if (event.getLevel() == Level.DEBUG) {
            return debugColor + super.format(event) + END_COLOR;
        } else {
            throw new RuntimeException("Unsupported Level " + event.toString());
        }
    }

    private String makeFgString(String fgColorName) {
        if (fgColorName.toLowerCase().equals("black")) {
            return FG_BLACK;
        } else if (fgColorName.toLowerCase().equals("red")) {
            return FG_RED;
        } else if (fgColorName.toLowerCase().equals("green")) {
            return FG_GREEN;
        } else if (fgColorName.toLowerCase().equals("yellow")) {
            return FG_YELLOW;
        } else if (fgColorName.toLowerCase().equals("blue")) {
            return FG_BLUE;
        } else if (fgColorName.toLowerCase().equals("magenta")) {
            return FG_MAGENTA;
        } else if (fgColorName.toLowerCase().equals("cyan")) {
            return FG_CYAN;
        } else if (fgColorName.toLowerCase().equals("white")) {
            return FG_WHITE;
        }
        System.err.println("log4j: ColoredPatternLayout Unsupported FgColor " + fgColorName);
        return "-1";
    }

    private String makeBgString(String bgColorName) {
        if (bgColorName.toLowerCase().equals("null")) {
            return BG_NULL;
        } else if (bgColorName.toLowerCase().equals("black")) {
            return BG_BLACK;
        } else if (bgColorName.toLowerCase().equals("red")) {
            return BG_RED;
        } else if (bgColorName.toLowerCase().equals("green")) {
            return BG_GREEN;
        } else if (bgColorName.toLowerCase().equals("yellow")) {
            return BG_YELLOW;
        } else if (bgColorName.toLowerCase().equals("blue")) {
            return BG_BLUE;
        } else if (bgColorName.toLowerCase().equals("magenta")) {
            return BG_MAGENTA;
        } else if (bgColorName.toLowerCase().equals("cyan")) {
            return BG_CYAN;
        } else if (bgColorName.toLowerCase().equals("white")) {
            return BG_WHITE;
        }
        System.err.println("log4j: ColoredPatternLayout Unsupported BgColor " + bgColorName);
        return "-1";
    }

    private String makeAttributeString(String attributeName) {
        if (attributeName.toLowerCase().equals("normal")) {
            return ATTR_NORMAL;
        } else if (attributeName.toLowerCase().equals("bright")) {
            return ATTR_BRIGHT;
        } else if (attributeName.toLowerCase().equals("dim")) {
            return ATTR_DIM;
        } else if (attributeName.toLowerCase().equals("underline")) {
            return ATTR_UNDERLINE;
        } else if (attributeName.toLowerCase().equals("blink")) {
            return ATTR_BLINK;
        } else if (attributeName.toLowerCase().equals("reverse")) {
            return ATTR_REVERSE;
        } else if (attributeName.toLowerCase().equals("hidden")) {
            return ATTR_HIDDEN;
        }
        System.err.println("log4j: ColoredPatternLayout Unsupported Attribute " + attributeName);

        return "-1";
    }

    private String makeColorString(String colorName) {
        StringTokenizer tokenizer = new StringTokenizer(colorName, CONFIGURATION_SEPARATOR);
        String fgColor = FG_WHITE;
        String bgColor = BG_BLACK;
        String attr = ATTR_NORMAL;
        if (!tokenizer.hasMoreTokens()) {
            return PREFIX + ATTR_NORMAL + SEPARATOR + FG_WHITE + SUFFIX;
        }
        if (tokenizer.hasMoreTokens()) {
            fgColor = makeFgString(tokenizer.nextToken());
        }
        if (tokenizer.hasMoreTokens()) {
            bgColor = makeBgString(tokenizer.nextToken());
        }
        if (tokenizer.hasMoreTokens()) {
            attr = makeAttributeString(tokenizer.nextToken());
        }

        StringBuilder result = new StringBuilder();
        result.append(PREFIX).append(attr).append(SEPARATOR).append(fgColor);
        if (!bgColor.toLowerCase().equals("null")) {
            result.append(SEPARATOR).append(bgColor).append(SUFFIX);
        } else {
            result.append(SUFFIX);
        }
        return result.toString();
    }

    public String getFatalErrorColor() {
        return fatalErrorColor;
    }

    public void setFatalErrorColor(String colorName) {
        fatalErrorColor = makeColorString(colorName);
    }

    public String getErrorColor() {
        return errorColor;
    }

    public void setErrorColor(String colorName) {
        errorColor = makeColorString(colorName);
    }

    public String getWarnColor() {
        return warnColor;
    }

    public void setWarnColor(String colorName) {
        warnColor = makeColorString(colorName);
    }

    public String getInfoColor() {
        return infoColor;
    }

    public void setInfoColor(String colorName) {
        infoColor = makeColorString(colorName);
    }

    public String getDebugColor() {
        return debugColor;
    }

    public void setDebugColor(String colorName) {
        debugColor = makeColorString(colorName);
    }

}