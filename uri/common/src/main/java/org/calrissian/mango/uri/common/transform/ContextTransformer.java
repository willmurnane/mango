package org.calrissian.mango.uri.common.transform;

public interface ContextTransformer<T> extends Transformable<T> {

    String getContextName();
}