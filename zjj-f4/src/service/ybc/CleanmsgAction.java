package service.ybc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.core.Action;
import service.core.ActionForm;
import service.core.ActionForword;

public class CleanmsgAction extends Action{

	@Override
	public ActionForword execute(HttpServletRequest request,
			HttpServletResponse response, ActionForm actionForm)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().removeAttribute("msg");
		return null;
	}

}
