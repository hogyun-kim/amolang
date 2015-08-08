package net.amolang.core.dao;

import java.sql.SQLException;

import amolang_AbstractedQuery.AbstractedQuery.AbstractedQuery;
import amolang_AbstractedQuery.ExprType.MultipleExprType;
import net.amolang.core.dao.admindb.AdminDBinfo;
import net.amolang.core.dao.searchcondition.SearchCondition;
import net.amolang.core.model.Component;

public class ComponentDaoImpl implements ComponentDao {

	Component component;
	
	public void setComponent(Component component) {
		this.component = component;
	}
	
	@Override
	public Component selectOne(SearchCondition searchcondition) {
		
		String[] names = searchcondition.getComponent_names();
		
		try {
	
			AbstractedQuery abstractedquery = new AbstractedQuery(AdminDBinfo.DBTYPE,
					AdminDBinfo.IP, AdminDBinfo.PORT, AdminDBinfo.DBNAME, AdminDBinfo.USERNAME,
					AdminDBinfo.PASSWORD);
	
			if(searchcondition.getPathCount() < 4) {
				
				abstractedquery.select("*").from("component")
				.where(new MultipleExprType().equal("name",	"'" +names[names.length - 1] +"'")
						.and(new MultipleExprType().equal("parent_id", "-1")));
			}
			else {
				
				abstractedquery.select("*").from("component").from(new AbstractedQuery(AdminDBinfo.DBTYPE)
				.select("id", "pid").from("component")
				.where(new MultipleExprType().equal("name", "'" +names[names.length - 2] +"'")), "component_parent")
				.where(new MultipleExprType().equal("name", "'" +names[names.length - 1] +"'")
				.and(new MultipleExprType().equal("component.parent_id", "component_parent.pid")));
			}
					
			abstractedquery.excuteQuery();
			
			while(abstractedquery.next()) {
				component.setId(abstractedquery.getInt(1));
				component.setName(abstractedquery.getString(2));
				component.setParent_id(abstractedquery.getInt(3));
				component.setArg_table(abstractedquery.getString(4));
				component.setArg_columns(abstractedquery.getString(5));
				component.setArg_params(abstractedquery.getString(6));
				component.setVersion(abstractedquery.getString(7));
			}
			
			abstractedquery.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return component;
	}

}
