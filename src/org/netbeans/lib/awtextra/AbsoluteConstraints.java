package org.netbeans.lib.awtextra;

import java.awt.Dimension;

/**
 * Minimal stub of NetBeans' AbsoluteConstraints used by generated forms.
 * This implementation only stores coordinates and sizes and is sufficient
 * for compilation and basic runtime layout.
 */
public class AbsoluteConstraints {
    public int x;
    public int y;
    public int width;
    public int height;

    public AbsoluteConstraints(int x, int y) {
        this(x, y, -1, -1);
    }

    public AbsoluteConstraints(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public AbsoluteConstraints(java.awt.Point p) {
        this(p.x, p.y, -1, -1);
    }

    public AbsoluteConstraints(java.awt.Point p, Dimension d) {
        this(p.x, p.y, d.width, d.height);
    }
}
