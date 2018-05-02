package studys.action;

import java.sql.Date;

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
 *　ユーザー情報更新関連ロジック。
 */
public class UpdateAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception{
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		UserForm userForm = (UserForm) form;
		
		String id = userForm.getId();
		String name = userForm.getName();
		String kana = userForm.getKana();
		Date birth = userForm.getBirth();
		String club = userForm.getClub();
		
		UserForm user = new UserForm(id, name, kana, birth, club);
		
		String cmd = req.getParameter("cmd");
		
		if(cmd.equals("updateCheck")) {
			req.setAttribute("user", user);
			return mapping.findForward("update");
		}else {
			DBconnect dBconnect = new DBconnect();
			dBconnect.updateExec("update user1 set name='" + name + "', kana='" + kana + "' where id='" + id + "'");
			dBconnect.updateExec("update userdetail set birth='" + birth + "', club='" + club + "' where id='" + id + "'");

			req.setAttribute("result", "データを更新しました。");
			return mapping.findForward("success");
		}
	}
}
