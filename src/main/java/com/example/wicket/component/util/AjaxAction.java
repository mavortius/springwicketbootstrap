package com.example.wicket.component.util;

import org.apache.wicket.ajax.AjaxRequestTarget;

import java.io.Serializable;

/**
 * Stands for ajax request.
 *
 * <p>
 * This interface would be used where a HTML form is not necessarily needed,
 * for instance in a link: AjaxLink, AjaxFallbackLink.
 *
 * Or any ajax-aware component: RadioChoice.
 */
@FunctionalInterface
public interface AjaxAction extends Serializable {
    public abstract void onClick(AjaxRequestTarget target);
}
