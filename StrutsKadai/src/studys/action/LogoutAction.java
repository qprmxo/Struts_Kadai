package studys.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author choi.hyuncheol
 *　ユーザーログアウト関連ロジック。
 */
public class LogoutAction extends Action{
	
	private HttpSession session = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		session = req.getSession();
		session.invalidate();
		
		req.setAttribute("cmd", "fail");
		req.setAttribute("result", "ログアウトしました。");
		
		return mapping.findForward("result");
	}
}
