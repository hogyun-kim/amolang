package net.amolang.core.service;

import java.util.ArrayList;
import java.util.List;

import net.amolang.core.dao.DBinfoDao;
import net.amolang.core.model.DBinfo;

public class GetDBinfoServiceImpl implements GetDBinfoService {

	private DBinfoDao dbinfodao;
	private DBinfo dbinfo;
	
	public void setDBinfoDao(DBinfoDao dbinfodao) {
		this.dbinfodao = dbinfodao;
	}
	
	public void setDBinfo(DBinfo dbinfo) {
		this.dbinfo = dbinfo;
	}

	@Override
	public List<String> getDbinfoFormList() {
		
		dbinfo = dbinfodao.selectOne();
		List<String> dbconnectinfo = new ArrayList<String>();
		
		dbconnectinfo.add(dbinfo.getDbtype());
		dbconnectinfo.add(dbinfo.getIp());
		dbconnectinfo.add(dbinfo.getPort());
		dbconnectinfo.add(dbinfo.getDbname());
		dbconnectinfo.add(dbinfo.getUsername());
		dbconnectinfo.add(dbinfo.getPassword());
		
		return dbconnectinfo;
	}

}
