package studys.action;

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
 *　ユーザー削除関連ロジック。
 */
public class DeleteAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception{
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		UserForm userForm = (UserForm) form;
		
		String id = userForm.getId();
		
		new DBconnect().updateExec("delete from userdetail where id='" + id + "'");
		new DBconnect().updateExec("delete from user1 where id='" + id + "'");
		
		req.setAttribute("result", "データを削除しました。");
		return mapping.findForward("success");
	}
}
