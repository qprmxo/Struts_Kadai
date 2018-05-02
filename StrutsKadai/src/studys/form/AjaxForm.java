package studys.form;

import org.apache.struts.action.ActionForm;

/**
 * @author choi.hyuncheol
 *　Ajaxでデータを運ぶためのフォーム。
 */
public class AjaxForm extends ActionForm{

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
