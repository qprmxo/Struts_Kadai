package studys.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import studys.form.UserForm;

/**
 * @author choi.hyuncheol
 *　ユーザー登録確認関連ロジック。
 */
public class JoincheckAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception{
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		UserForm userForm = (UserForm) form;
		
		String id = userForm.getId();
		String pass = userForm.getPass();
		String name = userForm.getName();
		String kana = userForm.getKana();

		Date birth = userForm.getBirth();
		String club = userForm.getClub();

		req.setAttribute("id", id);
		req.setAttribute("pass", pass);
		req.setAttribute("name", name);
		req.setAttribute("kana", kana);

		req.setAttribute("birth", birth);
		req.setAttribute("club", club);
		
		return mapping.findForward("success");
	}
}
