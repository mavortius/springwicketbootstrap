package com.example.wicket.component.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

/**
 * Factory class for creating Wicket components
 */
public class ComponentFactory {
    /**
     * Creates an ajax link.
     *
     * @param markupId the wicket id
     * @param action lambda to handle the event
     *
     * @return
     */
    public static AjaxFallbackLink<Void> newAjaxLink(String markupId, AjaxAction action) {
        AjaxFallbackLink<Void> link = new AjaxFallbackLink<Void>(markupId) {
            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                action.onClick(ajaxRequestTarget);
            }
        };
        return link;
    }

    /**
     * Creates a Label with dynamic String value.
     *
     * @param markupId the wicket id
     * @param supplier the lambda expression that defines what label to show.
     *
     * @return
     */
    public static Label newLabel(String markupId, StringSupplier supplier) {
        Label label = new Label(markupId, new Model<String>() {
            @Override
            public String getObject() {
                return supplier.get();
            }
        });
        label.setOutputMarkupId(true);
        return label;
    }

    /**
     * Creates a TextField.
     *
     * @param markupId the wicket id
     * @param label the label shown in case of error message.
     * @param required if the input is required or not.
     * @param behaviors optional validations, etc.
     *
     * @return
     */
    public static <T> TextField<T> newTextField(String markupId, String label, boolean required, Behavior ... behaviors) {
        TextField<T> textField = new TextField<T>(markupId);

        if(StringUtils.isNotBlank(label)) {
            textField.setLabel(new Model<String>(label));
        }

        textField.setRequired(required);

        if(behaviors != null && behaviors.length > 0) {
            for(Behavior b : behaviors) {
                textField.add(b);
            }
        }

        return textField;
    }

    /**
     * Creates a regular (non-ajax) button.
     *
     * @param markupId the wicket id
     * @param labelSupplier a lambda that provides the label to show on the button
     * @param action the lambda expression to handle the event
     *
     * @return
     */
    public static Button newButton(String markupId, StringSupplier labelSupplier, FormAction action) {
        Button button = new Button(markupId) {
            @Override
            public void onSubmit() {
                action.onSubmit();
            }
        };
        AttributeModifier modifier = new AttributeModifier("value", new Model<String>() {
            @Override
            public String getObject() {
                return labelSupplier.get();
            }
        });

        button.add(modifier);
        return button;
    }
}
