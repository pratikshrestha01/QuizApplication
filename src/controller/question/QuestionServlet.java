package controller.question;

import controller.user.SessionCreator;
import domains.question.Question;
import service.question.QuestionService;
import utils.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by User on 8/8/2016.
 */
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
        if (page.equalsIgnoreCase("list")) {

            List<Question> questionList = new QuestionService().getQuestionList();
            request.setAttribute("questionList", questionList);

            RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
            rd.forward(request, response);

        }
        if (page.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            new QuestionService().delete(id);

            List<Question> questionList = new QuestionService().getQuestionList();
            request.setAttribute("questionList", questionList);

            RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
            rd.forward(request, response);

        }
        if (page.equalsIgnoreCase("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Question question = new QuestionService().getQuestion(id);

            request.setAttribute("question",question);
            RequestDispatcher rd = request.getRequestDispatcher("question/edit.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("addQuestionform")) {
            RequestDispatcher rd = request.getRequestDispatcher("question/addquestionform.jsp");
            rd.forward(request, response);
        }

        if (page.equalsIgnoreCase("addquestion")) {
            Question question = new Question();

            question.setQuestion(request.getParameter("question"));
            question.setOption1(request.getParameter("option1"));
            question.setOption2(request.getParameter("option2"));
            question.setOption3(request.getParameter("option3"));
            question.setOption4(request.getParameter("option4"));
            question.setRight_ans(request.getParameter("right_ans"));


            new QuestionService().insert(question);
            List<Question> questionList = new QuestionService().getQuestionList();
            request.setAttribute("questionList", questionList);

            RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
            rd.forward(request, response);


        }
        if (page.equalsIgnoreCase("update")) {
            Question question = new Question();
            question.setId(Integer.parseInt(request.getParameter("id")));
            question.setQuestion(request.getParameter("question"));
            question.setOption1(request.getParameter("option1"));
            question.setOption2(request.getParameter("option2"));
            question.setOption3(request.getParameter("option3"));
            question.setOption4(request.getParameter("option4"));
            question.setRight_ans(request.getParameter("right_ans"));

            new QuestionService().update(question);

            List<Question> questionList = new QuestionService().getQuestionList();
            request.setAttribute("questionList", questionList);
            RequestDispatcher rd = request.getRequestDispatcher("question/list.jsp");
            rd.forward(request, response);
        }


        if (page.equalsIgnoreCase("pquiz")) {


            String query = "delete  from result where userid=?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            try {
                HttpSession session = request.getSession();
                pstm.setInt(1, Integer.parseInt("" + session.getAttribute("id")));
                pstm.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // Object[] ids = {"1"};
            List<Question> question = new QuestionService().getQuestion(new int[]{0});
            System.out.println("printin qq size "+ question.size());
            Random rand = new Random();

            if (question.size() > 1) {
                int n = rand.nextInt(question.size()) + 1;
                Question qqo = new Question();
                int chkre=0;
                for(Question qq: question){
                    if(chkre==(n-1)){
                        qqo=qq;
                    }
                    chkre++;
                }
                System.out.println("prrinting random "+ n);
                try {
                    request.setAttribute("question", qqo );
                } catch (java.lang.Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                try {

                    Question qqo = new Question();

                    for(Question qq: question){
                            qqo=qq;
                    }
                    request.setAttribute("question", qqo);
                } catch (java.lang.Exception exception) {
                    exception.printStackTrace();
                }
            }


            RequestDispatcher rd = request.getRequestDispatcher("question/pquiz.jsp");
            rd.forward(request, response);
        }
        if (page.equalsIgnoreCase("qsubmit")) {

            //getQuestion from DB
            // check right Ans and insert it into result table
            //select Ids from result table

            int id = Integer.parseInt(request.getParameter("id"));
            int marks = getMarks(id, request.getParameter("value"));
            SessionCreator str= new SessionCreator();
            HttpSession session = request.getSession();
           System.out.println("printing id "+ session.getAttribute("id"));

            new QuestionService().insertMarks(marks, id, Integer.parseInt("" + session.getAttribute("id")) );
            int ids[] = new QuestionService().getIds();
            List<Question> question = new QuestionService().getQuestion(ids);
            if (question.size() <1) {

                QuestionService qs= new QuestionService();

                int i=qs.retriveResult();
                //  System.out.println("result is"+i);
                //request.setAttribute("i",i);
                // qs.setResultss(i);

                request.setAttribute("i",i);


                int uid=(Integer)session.getAttribute("id");

                int bScore = qs.getBestScore(uid);
                if(bScore == 0){
                    //insert score
                    qs.insertBestScore(uid, i);
                }
                else{
                    //update score
                    if(i>0 && i>bScore){
                        qs.updateBestScore(uid, i);
                    }
                }
                //qs.insertBestScore(uid,i);

                //set best score for view
                request.setAttribute("bScore",bScore);
//high score

                //String name=(String)session.getAttribute("username");
                 int hScore=qs.getHighScore();
                request.setAttribute("hScore",hScore);


                QuestionService q=new QuestionService();



                RequestDispatcher rd = request.getRequestDispatcher("question/score.jsp");
                rd.forward(request, response);
            }else{

                Random rand = new Random();

                if (question.size() > 1) {
                    int n = rand.nextInt(question.size()) + 1;
                    Question qqo = new Question();
                    int chkre=0;
                    for(Question qq: question){
                        if(chkre==(n-1)){
                            qqo=qq;
                        }
                        chkre++;
                    }
                    System.out.println("prrinting random "+ n);
                    try {
                        request.setAttribute("question", qqo );
                    } catch (java.lang.Exception exception) {
                        exception.printStackTrace();
                    }
                } else {
                    try {

                        Question qqo = new Question();

                        for(Question qq: question){
                            qqo=qq;
                        }
                        request.setAttribute("question", qqo);
                    } catch (java.lang.Exception exception) {
                        exception.printStackTrace();
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher("question/pquiz.jsp");
                rd.forward(request, response);

            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public int getMarks(int id, String correct_ans) {
        Question question = new QuestionService().getQuestion(id);
        if (question.getRight_ans().equalsIgnoreCase(correct_ans)) {
            return 1;
        }else return 0;
    }
}
