package com.mpen.util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.io.IOException;

public class MouseUtil {
    public static Robot robot;
    public static int width;
    public static int height;
    static {
        try {
            robot = new Robot();
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            width = d.width;
            height = d.height;
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    /**
     * 鼠标移动.
     */
    public static void move(int x, int y) throws IOException {
        if (x >= width) {
            x = width;
        } else if (x <= 0) {
            x = 0;
        }
        if (y >= height) {
            y = height;
        } else if (y <= 0) {
            y = 0;
        }
        robot.mouseMove(x, y);
    }

    /**
     * 鼠标左键点击.
     * 
     */
    public static void leftCLick() {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    /**
     * 鼠标右键点击.
     * 
     */
    public static void rightCLick() {
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    /**
     * 鼠标滑轮滚动.
     * 
     */
    public static void roll() {
        robot.mouseWheel(5);
    }

}
