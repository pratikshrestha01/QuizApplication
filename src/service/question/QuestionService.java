package service.question;

import domains.question.Question;
import domains.user.User;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 8/8/2016.
 */
public class QuestionService {
    int re;

    public List<Question> getQuestionList() {

        List<Question> questionList = new ArrayList<Question>();

        try {
            String query = "select * from tbl_question";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setQuestion(rs.getString("question"));
                question.setId(rs.getInt("id"));
                question.setRight_ans(rs.getString("correct"));
                question.setOption1(rs.getString("opt1"));
                question.setOption2(rs.getString("opt2"));
                question.setOption3(rs.getString("opt3"));
                question.setOption4(rs.getString("opt4"));

                questionList.add(question);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    public int[] getIds() {

        List<Integer> intList = new ArrayList<Integer>();
        try {
            String query = "select q_id from result";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("q_id");
                intList.add(id);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        int[] arr = new int[intList.size()];
        int i = 0;
        for (Integer qid : intList) {
            arr[i] = qid;
            i++;
        }
        return arr;
    }

    public void delete(int id) {
        try {
            String query = "delete from tbl_question where id=?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setInt(1, id);

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insert(Question question) {
        String query = "insert into tbl_question (question,opt1,opt2,opt3,opt4,correct) values(?,?,?,?,?,?)";

        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setString(1, question.getQuestion());
            pstm.setString(2, question.getOption1());
            pstm.setString(3, question.getOption2());
            pstm.setString(4, question.getOption3());
            pstm.setString(5, question.getOption4());
            pstm.setString(6, question.getRight_ans());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertMarks(int marks, int id, int userid) {
        String query = "insert into result (q_id,marks,userid) values(?,?,?)";

        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try {
            pstm.setInt(1, id);
            pstm.setInt(2, marks);
            pstm.setInt(3, userid);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  List<Question> getQuestion(int[] ids) {
        String values = "";

        List<Question> questionList = new ArrayList<Question>();
        try {
            String query = "select * from tbl_question where id not in(";
            for (int id : ids) {
                values += id + ",";
            }
            query = query + values;
            int ind = query.lastIndexOf(",");
            query = query.substring(0, ind);
            query = query + ")";
            System.out.println("printing query "+query);
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                System.out.println("system called ");
                Question question = new Question();
                question = new Question();
                question.setQuestion(rs.getString("question"));
                question.setId(rs.getInt("id"));
                question.setRight_ans(rs.getString("correct"));
                question.setOption1(rs.getString("opt1"));
                question.setOption2(rs.getString("opt2"));
                question.setOption3(rs.getString("opt3"));
                question.setOption4(rs.getString("opt4"));

                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return questionList;
    }


    public Question getQuestion(int id) {
        String values = "";
        Question question = null;
        try {
            String query = "select * from tbl_question where id=?";

            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setQuestion(rs.getString("question"));
                question.setId(rs.getInt("id"));
                question.setRight_ans(rs.getString("correct"));
                question.setOption1(rs.getString("opt1"));
                question.setOption2(rs.getString("opt2"));
                question.setOption3(rs.getString("opt3"));
                question.setOption4(rs.getString("opt4"));
                //question.setOption4(rs.getString("right_ans"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return question;
    }
    public void update(Question question) {
        try {
            String query = "update tbl_question set question=? , opt1=? , opt2=? ,opt3=?, opt4=?, correct=? where id=?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setString(1, question.getQuestion());
            pstm.setString(2, question.getOption1());
            pstm.setString(3, question.getOption2());
            pstm.setString(4, question.getOption3());
            pstm.setString(5, question.getOption4());
            pstm.setString(6, question.getRight_ans());
            pstm.setInt(7,question.getId());
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int retriveResult() {
        try {
            String query = "select * from result where marks=1";
            PreparedStatement pstmm = new DatabaseConnection().getPreparedStatement(query);
            ResultSet rs = pstmm.executeQuery();
            int i = 0;
            while (rs.next()) {
                i++;


            }
            return i;
        } catch (Exception e) {

        }

        return 0;
    }
    public void setResultss(int i){
        int re = i ;


    }

    public void insertBestScore(int id,int bscore) {
        try {
            String query = "insert into bestscore (uid,bscore) values(?,?)";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setInt(1,id);
            pstm.setInt(2,bscore);
            pstm.execute();

        }catch (Exception e){

        }
    }


        public int getBestScore(int id){
            int rw = 0;
            try {
                String query = "select * from bestscore where uid=?";
                PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
                pstm.setInt(1, id);
                ResultSet rs=pstm.executeQuery();
                while (rs.next()) {
                    rw = rs.getInt("bscore");
                    System.out.println(rw);
                    System.out.println("Printing Bestscore row");
                }


            } catch (Exception e) {

            }
            return rw;
        }
    public int getHighScore(){
        int r=0 ;
        try{
            String query="select max(bscore) from bestscore";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {
                r = rs.getInt("bscore");
            }
        }catch(Exception e){
            e.printStackTrace();

        }
          System.out.println("high score printiing"+r);
            return r;
    }

    public int updateBestScore(int id, int bscore){
        try {
            String query = "update bestscore set bscore=? where uid=? ";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setInt(1,bscore);
            pstm.setInt(2, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

            return 0;
    }


}
