package com.AutomatedMeetingBookingSystem.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
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

		ArrayList<User> userList = new ArrayList<>();
		try {

			File file = new File(request.getParameter("filePath"));
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);

			doc.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

			NodeList nodeList = doc.getElementsByTagName("user");

			for (int i = 0; i < nodeList.getLength(); ++i) {
				Node node = nodeList.item(i);
				System.out.println("\nNode Name :" + node.getNodeName());
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element tElement = (Element) node;
					User user = new User();
					user.setUserId(Integer.parseInt(tElement.getElementsByTagName("id").item(0).getTextContent()));
					user.setName(tElement.getElementsByTagName("name").item(0).getTextContent());
					user.setEmail(tElement.getElementsByTagName("email").item(0).getTextContent());
					user.setPhoneNumber(tElement.getElementsByTagName("phoneNumber").item(0).getTextContent());
					user.setRole(tElement.getElementsByTagName("role").item(0).getTextContent());
					user.setCredit(Integer.parseInt(tElement.getElementsByTagName("credit").item(0).getTextContent()));
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

