package com.example.wicket.component.util;

import java.io.Serializable;

/**
 * Stands for a simple "form submission".
 *
 * <p>
 * It might be used in any HTML control that submits an
 * form: Button.
 */
@FunctionalInterface
 public interface FormAction extends Serializable {
    public abstract void onSubmit();
}
