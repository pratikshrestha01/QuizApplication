package controller.question;

import domains.question.Question;
import service.question.QuestionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nabin on 8/22/2016.
 */
@WebServlet(name = "QuestionServlet2")
public class QuestionServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Question question = new Question();
        question.setId(Integer.parseInt(request.getParameter("id")));
        question.setQuestion(request.getParameter("question"));
        question.setOption1(request.getParameter("option1"));
        question.setOption2(request.getParameter("option2"));
        question.setOption3(request.getParameter("option3"));
        question.setOption4(request.getParameter("option4"));
        question.setRight_ans(request.getParameter("right_ans"));
        System.out.println(question.getId());

        new QuestionService().insert(question);

        List<Question> questionList = new QuestionService().getQuestionList();
        request.setAttribute("questionList", questionList);

        RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
