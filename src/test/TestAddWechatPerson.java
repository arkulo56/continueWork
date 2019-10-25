package test;

import java.sql.SQLException;

import org.junit.Test;

import addPerson.AddWechatPerson;

public class TestAddWechatPerson {

	@Test
	public void test1() throws ClassNotFoundException, SQLException
	{
		AddWechatPerson target = new AddWechatPerson();
		target.run();
	}
}
