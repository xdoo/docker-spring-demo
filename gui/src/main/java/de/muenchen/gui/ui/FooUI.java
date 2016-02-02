package de.muenchen.gui.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author claus
 */
@SpringUI
@Theme("valo")
public class FooUI extends UI {

    @Autowired
    private FooBean foo;
    
    @Autowired
    private FooService service;
    
    private Label label;
    
    @Override
    protected void init(VaadinRequest request) {
        HorizontalLayout layout = new HorizontalLayout();
        
        layout.addComponent(this.label);
        layout.addComponent(this.createPlus());
        layout.setSpacing(true);
        setContent(layout);
    }
    
    private Button createPlus() {
        return new Button("plus", (Button.ClickEvent event) -> {
            service.plusOne(foo);
            label.setCaption(Integer.toString(foo.getX()));
        });
    }
    
    private void createLabel() {
        this.label = new Label(Integer.toString(this.foo.getX()));
    }
    
}
