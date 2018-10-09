CREATE PROCEDURE PROC_GENERATE_QUESTIONS (@IDTest INT)
AS
BEGIN
		SELECT T1.idQuestion, T1.enonce, T1.idTheme, T1.media, T1.points
	FROM(
    SELECT QUESTION.idQuestion, QUESTION.enonce, QUESTION.idTheme, QUESTION.media, QUESTION.points, SECTION_TEST.nbQuestionsATirer, ROW_NUMBER() OVER (ORDER BY NEWID()) r
      	FROM QUESTION
			JOIN SECTION_TEST ON SECTION_TEST.idTheme = QUESTION.idTheme
	WHERE SECTION_TEST.idTest = @IDTest	
	) AS T1
	where T1.r <= T1.nbQuestionsATirer; 
END
	