package com.example.wicket.component.util;

/*OBS: I did not use Java's own java.util.function.Supplier because it's
 * not serializable. */

import java.io.Serializable;

/**
 * Simply returns a String.
 */
@FunctionalInterface
 public interface StringSupplier extends Serializable {
    public String get();
}
