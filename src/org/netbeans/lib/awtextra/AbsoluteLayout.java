package org.netbeans.lib.awtextra;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 * Minimal stub of NetBeans' AbsoluteLayout used by generated forms.
 * This provides just enough behavior for compilation and simple layout.
 */
public class AbsoluteLayout implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return parent.getPreferredSize();
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return parent.getMinimumSize();
    }

    @Override
    public void layoutContainer(Container parent) {
        for (Component c : parent.getComponents()) {
            // Use the component's current bounds when they are already set by generated code
            Rectangle b = c.getBounds();
            if (b != null && b.width > 0 && b.height > 0) {
                continue;
            }
            // If a constraint object is attached as a client property named "absoluteConstraints", use it
            try {
                Object prop = null;
                if (c instanceof JComponent) {
                    prop = ((JComponent) c).getClientProperty("absoluteConstraints");
                }
                if (prop instanceof AbsoluteConstraints) {
                    AbsoluteConstraints ac = (AbsoluteConstraints) prop;
                    int w = ac.width > 0 ? ac.width : c.getPreferredSize().width;
                    int h = ac.height > 0 ? ac.height : c.getPreferredSize().height;
                    c.setBounds(ac.x, ac.y, w, h);
                }
            } catch (Throwable ignore) {
                // best-effort layout only
            }
        }
    }
}
