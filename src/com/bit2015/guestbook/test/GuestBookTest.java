package com.bit2015.guestbook.test;

import java.util.List;

import com.bit2015.guestbook.dao.GuestBookDao;
import com.bit2015.guestbook.vo.GuestBookVo;

public class GuestBookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAllList();
	}

	public static void getAllList()
	{
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList();
		
		for (GuestBookVo vo : list) {
			System.out.println(vo);
		}
		
	}
}
