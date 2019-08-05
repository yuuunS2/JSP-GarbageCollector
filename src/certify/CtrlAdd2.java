package certify;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import certify.Controller;
import certify.RequestMapping;
import certify.Util;


@RequestMapping("/certify_add2.do")
public class CtrlAdd2 implements Controller{

	@Override
	public String HandleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception 
	{
		System.out.println("�߰� ��");

		System.out.println("���� �߰� ����");
		// fileup ���͸��� ���� ������ġ (������) ���� �ľ��Ѵ�.
		String path = request.getServletContext().getRealPath("/WEB-INF/fileup");
		System.out.println( path );
		
		// cos.jar���� �����Ǵ� Ŭ����
		// ��� �ø� �� �̸��� ������ �÷��� �̸��� �ٸ� �� �ִ�.
		MultipartRequest mpr = new MultipartRequest( request , path , 1024*1024*20 , "UTF-8" ,
				new DefaultFileRenamePolicy()); // �� �̸��� ��ĥ �� �̸� �ٲ㼭 �÷��ش�.
		// new DefaultFileRenamePolicy() ��ſ� null���� �ָ� �����.
		// ���ε��� ���� ���� �̸� 
		String ofn = mpr.getOriginalFileName("photo");
		// �ٲ� �̸�
		String fsn = mpr.getFilesystemName("photo");
		System.out.println(ofn+"->"+fsn);
		//MultipartRequest ���� request.getParameter ������ .
		// ��� MultipartRequest ���� getParameter�� ����.
		// �ѱ�ó���� ���ο��� ���ִ���(UTF-8�� �����ؼ�)
		String title = mpr.getParameter("title");
		System.out.println(title);
		
		

		System.out.println("���� DB insert ����");
		String details = Util.h(mpr.getParameter("details"));
		CertifyVO vo = new CertifyVO();
		 vo.setSerialNo(mpr.getParameter("certify_serialNo"));
		 vo.setHelperID("helper");
		 vo.setDetails(details);;
		 vo.setHousePlace(mpr.getParameter("housePlace"));
		 vo.setCertify_photo_ofn(ofn);
		 vo.setCertify_photo_fsn(fsn);
		 CertifyDAO dao = new CertifyDAO_OracleImpl();
		 dao.insert(vo);

		System.out.println(dao.toString());

		return "redirect:/certify_list.do";
	}

}
