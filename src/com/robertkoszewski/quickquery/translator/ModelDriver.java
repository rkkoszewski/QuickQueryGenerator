package com.robertkoszewski.quickquery.translator;

import com.robertkoszewski.quickquery.model.SQLModel;

public interface ModelDriver {

	String toString(SQLModel model);

}
