package studys.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import jdbc.DBconnect;
import studys.form.AjaxForm;
import studys.form.UserForm;

/**
 * @author choi.hyuncheol
 *　ユーザーIDチェック関連ロジック。
 */
public class IDcheckAction extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception{
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		
		AjaxForm ajaxForm = (AjaxForm) form;
		res.setContentType("text/text;charset=utf-8");
		res.setHeader("cache-control", "no-cache");
		
		String id = ajaxForm.getId();
		UserForm user = new DBconnect().findList(id);
		
		PrintWriter out = res.getWriter();
		
		if(user == null) {
			out.println("使用できます。");
		}else {
			out.println("このユーザーIDは既に使用されています。");
		}

		out.flush();
		
		return null;
	}
}
