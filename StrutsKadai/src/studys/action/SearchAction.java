package studys.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import jdbc.DBconnect;
import studys.form.UserForm;

/**
 * @author choi.hyuncheol
 *　ユーザー情報検索関連ロジック。
 */
public class SearchAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception{
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		UserForm userForm = (UserForm) form;
		
		String id = userForm.getId();
		String name = userForm.getName();
		String kana = userForm.getKana();
		
		String cmd = req.getParameter("cmd");
		
		ArrayList<UserForm> list = new DBconnect().findList(id, name, kana);
		
		req.setAttribute("id", id);
		req.setAttribute("name", name);
		req.setAttribute("kana", kana);
		req.setAttribute("list", list);
		
		if(cmd.equals("update")) {
			UserForm user = new DBconnect().findList(id);
			req.setAttribute("user", user);
			return mapping.findForward("update");
			
		}else if(cmd.equals("delete")) {
			UserForm user = new DBconnect().findList(id);
			req.setAttribute("user", user);
			return mapping.findForward("delete");
			
		}else {
			return mapping.findForward("success");
		}
	}
}
