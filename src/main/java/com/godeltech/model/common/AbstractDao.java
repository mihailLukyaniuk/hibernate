package com.godeltech.model.common;

import com.google.common.base.Preconditions;

import java.io.Serializable;

public abstract class AbstractDao<T extends Serializable> implements Dao<T> {

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = Preconditions.checkNotNull(clazzToSet);
    }
}
