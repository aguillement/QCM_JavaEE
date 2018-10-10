package fr.eni.jee.bll.exam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.bo.Exam;
import fr.eni.jee.dal.EpreuveDAO;

/**
 * Servlet implementation class SelectExam
 */
@WebServlet("/Connected/SelectExam")
public class SelectExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectExam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Exam> exams = new ArrayList<Exam>();
		try {
			exams = EpreuveDAO.SearchByUser(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("exams", exams);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Restricted/ManageTest/SelectExam.jsp").forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
