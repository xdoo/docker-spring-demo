package de.muenchen.gui.ui;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import java.io.Serializable;

/**
 *
 * @author claus
 */
@SpringComponent
@VaadinSessionScope
public class FooBean implements Serializable {
    
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
}
