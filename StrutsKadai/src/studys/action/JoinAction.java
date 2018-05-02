package studys.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import jdbc.DBconnect;
import studys.form.UserForm;

/**
 * @author choi.hyuncheol
 *　ユーザー登録関連ロジック。
 */
public class JoinAction extends Action{
	
	private HttpSession session;

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception{
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		UserForm userForm = (UserForm) form;
		
		String id = userForm.getId();
		String pwd = userForm.getPass();
		String name = userForm.getName();
		String kana = userForm.getKana();
		
		Date birth = userForm.getBirth();
		String club = userForm.getClub();

		DBconnect dbconcet = new DBconnect();
		
		session = req.getSession();
		
		int n = dbconcet.updateExec("insert into user1 values('" + id + "','" + pwd + "','" + name + "','" + kana + "')");
		if(n>0) {
			dbconcet.updateExec("insert into userdetail values(seq_userdetail.nextval,'" + id + "','" + birth + "','" + club + "')");
			session.setAttribute("id", id);
			
			req.setAttribute("result", "データを登録しました。");
			return mapping.findForward("result");
		}else {
			req.setAttribute("result", "既に使用されているため、使用できません。");
			
			if(session.getAttribute("id") != null) {
				return mapping.findForward("result");
			}else {
			
				req.setAttribute("cmd", "fail");
				return mapping.findForward("result");
			}
		}
	}
}
