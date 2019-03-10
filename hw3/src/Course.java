/**
 * This class is hold information about a course teaching from Gebze Technical University.
 */
public class Course 
{
	private int semester;
	private String code, title;
	private int ectsCredit, gtuCredit;
	private String htl;

	/**
	 * Constructor is use for init all private variables.
	 * @param semester
	 * @param code
	 * @param title
	 * @param ectsCredit
	 * @param gtuCredit
	 * @param htl
	 */
	public Course(int semester,String code,String title,int ectsCredit,int gtuCredit,String htl){
		this.semester = semester;
		this.code = code;
		this.title = title;
		this.ectsCredit = ectsCredit;
		this.gtuCredit = gtuCredit;
		this.htl = htl;
	}

	/**
	 * Getter for semester
	 * @return semester
	 */
	public int getSemester(){
		return semester;
	}

	/**
	 * Getter for code
	 * @return code
	 */
	public String getCode(){
		return code;
	}

	/**
	 * Getter for title
	 * @return title
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Getter for ects credit
	 * @return ects credit
	 */
	public int getEctsCredit(){
		return ectsCredit;
	}

	/**
	 * Getter for gtu credit
	 * @return gtu credit
	 */
	public int getGtuCredit(){
		return gtuCredit;
	}

	/**
	 * Getter for htl
	 * @return htl
	 */
	public String getHtl(){
		return htl;
	}

	/**
	 * Setter for semester
	 * @param semester
	 */
	public void setSemester(int semester){
		this.semester = semester;
	}

	/**
	 * Setter for code
	 * @param code
	 */
	public void setCode(String code){
		this.code = code;
	}

	/**
	 * Setter for title
	 * @param title
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Setter for ects credit
	 * @param ectsCredit
	 */
	public void setEctsCredit(int ectsCredit){
		this.ectsCredit = ectsCredit;
	}

	/**
	 * Setter for gtu credit
	 * @param gtuCredit
	 */
	public void setGtuCredit(int gtuCredit){
		this.gtuCredit = gtuCredit;
	}

	/**
	 * Setter for htl
	 * @param htl
	 */
	public void setHtl(String htl){
		this.htl = htl;
	}

	/**
	 * Overridden toString method
	 * @return string of courses
	 */
	@Override
	public String toString() {
		return semester + " " + code + " " +
				title + " " + ectsCredit + " " +
				gtuCredit + " " +htl;
	}
}