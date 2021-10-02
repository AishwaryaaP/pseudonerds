package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.AutomatedMeetingBookingSystem.model.User;
import com.AutomatedMeetingBookingSystem.service.AdminServiceInterface;
import com.AutomatedMeetingBookingSystem.service.ServiceFactory;
import com.AutomatedMeetingBookingSystem.service.UserServiceImp;
import com.AutomatedMeetingBookingSystem.service.UserServiceInterface;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 * Servlet implementation class ImportUserController
 */

@MultipartConfig
public class ImportUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceInterface userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ImportUserController() {
		super();
		userService = ServiceFactory.getUserService();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ok out");
		ArrayList<User> userList = new ArrayList<>();
		try {
			System.out.println("ok in");
			Part filePart = request.getPart("myFile");
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();
//			String text = new String(fileContent.readAllBytes(), StandardCharsets.UTF_8);	
//			System.out.println(text);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(fileContent);
			System.out.println("between");
			doc.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

			NodeList nodeList = doc.getElementsByTagName("user");
			System.out.println(nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); ++i) {
				Node node = nodeList.item(i);
				System.out.println("\nNode Name :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element tElement = (Element) node;
					User user = new User();
//					System.out.println(tElement.getElementsByTagName("id").item(0).getTextContent());
//					user.setUserId(Integer.parseInt(tElement.getElementsByTagName("id").item(0).getTextContent()));
					//System.out.println(tElement.getElementsByTagName("name").item(0).getTextContent());

					user.setName(tElement.getElementsByTagName("name").item(0).getTextContent());
					//System.out.println(tElement.getElementsByTagName("email").item(0).getTextContent());

					user.setEmail(tElement.getElementsByTagName("email").item(0).getTextContent());
					user.setPhoneNumber(tElement.getElementsByTagName("phoneNumber").item(0).getTextContent());
					user.setRole(tElement.getElementsByTagName("role").item(0).getTextContent());
					System.out.println(user.toString());	
					userList.add(user);
				}
			}

		}

		// This exception block catches all the exception
		// raised.
		// For example if we try to access a element by a
		// TagName that is not there in the XML etc.
		catch (Exception e) {
			System.out.println(e);
		}
		boolean inserted = false;
		if (userList.size() > 0) {
			inserted = userService.addUsers(userList);
		}
		RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
					rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
