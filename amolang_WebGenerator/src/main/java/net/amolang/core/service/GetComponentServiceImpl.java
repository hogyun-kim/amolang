package net.amolang.core.service;

import net.amolang.core.dao.ComponentDao;
import net.amolang.core.dao.searchcondition.SearchCondition;
import net.amolang.core.model.Component;

public class GetComponentServiceImpl implements GetComponentService {

	ComponentDao componentdao;
	SearchCondition searchcondition;
	
	public void setComponentDao(ComponentDao componentdao) {
		this.componentdao = componentdao;
	}
	
	public void setSearchCondition(SearchCondition searchcondition) {
		this.searchcondition = searchcondition;
	}
	
	@Override
	public Component getComponent(String[] uri_token) {
		
		searchcondition.setComponent_names(uri_token);

		return componentdao.selectOne(searchcondition);
	}

}
