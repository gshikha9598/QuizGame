import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Database {
	int result=0;
	Connection con=null;
	String questions=null,option1=null,option2=null,option3=null,option4=null;
	int id=0,answer=0;
	public final String Database_name = "quizgame";
	public final String Database_user = "root";
	public final String Database_pass = "";

	List suryvetList = null;
	public List getConnection(String str) { 
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bytecode", "bytecode");

				String query="select * from test_surveytb where survey_type =?"; 
				PreparedStatement prepare1 = con.prepareStatement(query); 
				prepare1.setString(1, str);
				ResultSet result= prepare1.executeQuery();
				suryvetList = new ArrayList();
				while(result.next()) { 
					SurveyModel model = new SurveyModel();  
					model.setQuestion(result.getString("question_name"));
					model.setAnswer(result.getString("answer"));
					model.setOption1(result.getString("option1"));
					model.setOption2(result.getString("option2"));
					model.setOption3(result.getString("option3"));
					model.setOption4(result.getString("option4"));
					suryvetList.add(model);
				}   
			}catch(Exception ex) { 
				ex.printStackTrace();  
			}
			return suryvetList;
		
			
			}//init
	 
	 
	
		}//class
				