package net.amolang.core.dao;

import net.amolang.core.dao.searchcondition.SearchCondition;
import net.amolang.core.model.Component;

public interface ComponentDao {

	public Component selectOne(SearchCondition searchcondition);
}
